import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int n;
    int weight;
    Node(int n, int weight) {
        this.n = n;
        this.weight = weight;
    }
}
public class Main {
    static List<Node>[] graph;
    static int N, E;
    static final int INF = 87654321;

    static int dijkstra(int start, int end) {
        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int n = curr.n;
            int weight = curr.weight;

            if(weight > dp[n]) continue; // 현재 정점의 무게가 최선보다 크다면 넘어감

            for(Node node : graph[n]) {
                if(dp[node.n] > weight + node.weight) {
                    dp[node.n] = weight + node.weight;
                    pq.offer(new Node(node.n, dp[node.n]));
                }
            }
        }
        return dp[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
            graph[end].add(new Node(start, weight));
        } // 그래프 초기화 완료
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // u->v인 경우 : 1~u 다익스트라, u~v 다익스트라, v~N 다익스트라
        int min1 = dijkstra(1, u);
        min1 += dijkstra(u, v);
        min1 += dijkstra(v, N);

        // v->u인 경우 : 1~v 다익스트라, v~u 다익스트라, u~N 다익스트라
        int min2 = dijkstra(1, v);
        min2 += dijkstra(v, u);
        min2 += dijkstra(u, N);

        if(min1 >= INF || min2 >= INF) {
            System.out.println(-1); return;
        }
        System.out.println(Math.min(min1, min2));
    }
}