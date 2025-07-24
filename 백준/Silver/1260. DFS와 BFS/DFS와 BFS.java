import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        } // 그래프 초기화 완료

        // 정점 번호가 작은 것부터 방문하기 위해 각 점의 리스트를 정렬
        for(int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }
    static void dfs(int start) {
        ArrayList<Integer> list = graph[start];
        sb.append(start).append(" ");
        visited[start] = true;

        for(Integer n : list) {
            if(visited[n]) {
                continue;
            }
            dfs(n);
        }
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append(" ");
            ArrayList<Integer> list = graph[curr];

            for(int n : list) {
                if(visited[n]) {
                    continue;
                }
                q.offer(n);
                visited[n] = true;
            }
        }
    }
}
