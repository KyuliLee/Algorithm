import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int n;
    int time;
    Node(int n, int time) {
        this.n = n;
        this.time = time;
    }
}
public class Main {
    static List<Node>[] graph;
    static final int INF = 987654321;
    static int dijkstra(int start, int end, int N) {
        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        dp[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.time - n2.time);
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(curr.time > dp[curr.n]) continue; // dummy 데이터 제거

            for(Node node : graph[curr.n]) {
                if(dp[node.n] > dp[curr.n] + node.time) {
                    dp[node.n] = dp[curr.n] + node.time;
                    pq.offer(new Node(node.n, dp[node.n]));
                }
            }
        }
        return dp[end];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, time));
        } // 그래프 초기화 완료

        // 각 마을->X 다익스트라, X->각 마을 다익스트라
        // 출발점이 모두 다르므로 graph를 돌면서 X일 때를 제외한 모든 경우에 다익스트라를 2번씩 해야 한다.
        // 다익스트라의 리턴값은 최소 시간이고 그 중 최댓값을 구하자.
        int max = 0;
        for(int i=1; i<=N; i++) {
            if(i == X) continue;
            int studentMin = dijkstra(i, X, N);
            studentMin += dijkstra(X, i, N);
            max = Math.max(max, studentMin);
        }
        System.out.println(max);

    }
}