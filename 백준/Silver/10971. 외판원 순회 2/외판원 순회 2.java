import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int min = Integer.MAX_VALUE;
    static int start;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<N; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(min);
    }
    static void dfs(int first, int start, int cost, int depth) {
        if(depth == N && first == start) {
            min = Math.min(min, cost);
            return;
        }
        ArrayList<Integer> list = graph[start];
        for(int i=0; i<N; i++) {
            if(visited[i]) {
                continue;
            }
            int tempCost = list.get(i);
            if(tempCost == 0) {
                continue;
            }
            visited[i] = true;
            dfs(first, i, cost+tempCost, depth+1);
            visited[i] = false;

        }
    }
}
