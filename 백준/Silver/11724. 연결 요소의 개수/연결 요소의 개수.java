import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int component;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        } // 초기화 완료

        component = 0;
        for(int i=1; i<=N; i++) {
            ArrayList<Integer> list = graph[i];
            if(list.size()==0) {
                component++;
                continue;
            }
            if(visited[i]) {
                continue;
            }
            bfs(i);
            component++;
        }
        System.out.println(component);
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int v = q.poll();
            ArrayList<Integer> list = graph[v];

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
