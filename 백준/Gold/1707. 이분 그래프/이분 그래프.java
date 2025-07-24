import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] color;
    static boolean isBipartite = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=0; tc<TC; tc++) {

            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
        /*
        각 점이 색깔 1 또는 2로 정해진다.
        하나의 점에서 edge로 연결되어 있는 점의 색이 동일한 게 있으면 이분 그래프가 아님
         */
            graph = new ArrayList[V+1];
            for(int i=1; i<=V; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            color = new int[V+1];

            for(int i=1; i<=V; i++) {
                if(color[i]==0) {
                    isBipartite = isBipartite(i);
                }
                if(!isBipartite) {
                    break;
                }
            }
            if(isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    static boolean isBipartite(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        color[start] = 1;
        while(!q.isEmpty()) {
            int curr = q.poll();
            ArrayList<Integer> list = graph[curr];
            for(int v : list) {
                if(color[curr] == color[v]) {
                    return false;
                }

                if(color[v] == 0) {
                    q.offer(v);
                    if(color[curr]==1) {
                        color[v] = 2;
                    } else {
                        color[v] = 1;
                    }
                }
            }

        }
        return true;
    }

}
