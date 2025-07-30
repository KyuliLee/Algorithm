import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int vertex;
    int weight;
    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
public class Main {
    static int N;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int farfarNode;
    static int max = -1; // 트리 지름
    static int dist = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N==1) {
            System.out.println(0);
            return;
        }
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, weight));
            graph[e].add(new Node(s, weight));
        }
        visited[1] = true;
        dfs(1);
        visited = new boolean[N+1];
        dist = 0;
        max = -1;
        dfs(farfarNode);
        System.out.println(max);
    }
    static void dfs(int n) {
        visited[n] = true;
        ArrayList<Node> list = graph[n];
        for(Node node : list) {
            int vertex = node.vertex;
            int weight = node.weight;
            if(visited[vertex]) {continue;}

            dist += weight;
            dfs(vertex);
            if(dist > max) {
                max = dist;
                farfarNode = vertex;
            }
            dist -= weight;

        }
    }
}