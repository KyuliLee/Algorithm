import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<Node>[] graph;


    static class Node implements Comparable<Node>{
        int end;
        int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int solution(int start, int end) {
        int[] cost = new int[N+1]; // 시작 정점으로부터의 최단비용 저장
        Arrays.fill(cost, Integer.MAX_VALUE); // 처음에는 최대로 저장
        cost[start] = 0; // 시작 정점부터 시작 정점까지의 비용은 0
        boolean[] visited = new boolean[N+1]; // 동일 정점을 또 방문해서 사이클을 도는 것 방지
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // 시작하는 정점을 pq에 넣음

        while(!pq.isEmpty()) {
            Node currNode = pq.poll();
            int currEnd = currNode.end;
            int currCost = currNode.cost;

            if(visited[currEnd]) continue;

            visited[currEnd] = true;
            for(Node node : graph[currEnd]) {
                if(!visited[node.end] && cost[node.end] > cost[currEnd] + node.cost) {
                    cost[node.end] = cost[currEnd] + node.cost;
                    pq.add(new Node(node.end, cost[node.end]));
                }
            }
        }
        return cost[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        int departure = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        int answer = solution(departure, destination);
        System.out.println(answer);

    }

}
