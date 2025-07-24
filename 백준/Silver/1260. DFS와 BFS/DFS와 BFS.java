import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean dfsVisited[];
    static boolean bfsVisited[];
    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        } // 그래프 초기화 완료

        dfsVisited = new boolean[N+1];
        bfsVisited = new boolean[N+1];

        dfs(V);
        bfs(V);
        System.out.println(dfsSb);
        System.out.println(bfsSb);




    }
    static void dfs(int start) {
        dfsSb.append(start).append(" ");
        dfsVisited[start] = true;
        ArrayList<Integer> list = graph[start];
        for(int i=1; i<=N; i++) {
            if(list.contains(i)) {
                if (dfsVisited[i]) {
                    continue;
                }
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        bfsVisited[start] = true;
        q.offer(start);

        while(!q.isEmpty()) {
            int vertex = q.poll();
            ArrayList<Integer> list = graph[vertex];
            bfsSb.append(vertex).append(" ");

            for(int i=1; i<=N; i++) {
                if(bfsVisited[i]) {
                    continue;
                }
                if(list.contains(i)) {
                    q.offer(i);
                    bfsVisited[i] = true;
                }
            }
        }

    }
}