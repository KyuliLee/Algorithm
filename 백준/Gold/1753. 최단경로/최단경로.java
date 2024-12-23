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
    private static final int INF = 987654321;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[tmp].add(new Node(end, weight));
        } // 그래프 초기화 완료

        StringBuilder sb = new StringBuilder();

        int[] dp = new int[V+1];
        Arrays.fill(dp, INF);
        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight-n2.weight);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(curr.weight > dp[curr.n]) continue; // 현재 가중치가 베스트보다 크다면 넘어감

            for(Node node : graph[curr.n]) {
                if(dp[node.n] > dp[curr.n] + node.weight) {
                    dp[node.n] = dp[curr.n] + node.weight;
                    pq.offer(new Node(node.n, dp[node.n]));
                }
            }
        }

        for(int i=1; i<=V; i++) {
            if(i==start) {
                sb.append("0").append("\n");
            } else if(dp[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dp[i]).append("\n");
            }
        }
        System.out.print(sb);

    }

}