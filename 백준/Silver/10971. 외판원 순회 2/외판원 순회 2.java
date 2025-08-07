import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(min);
    }
    static void dfs(int start, int curr, int cost, int depth) {
        if(depth == N && start == curr) {
            min = Math.min(min, cost);
            return;
        }
        if(cost >= min) {
            return;
        }
        for(int i=0; i<N; i++) {
            if(visited[i]) {
                continue;
            }
            if(arr[curr][i] == 0) {
                continue;
            }
            visited[i] = true;
            dfs(start, i, cost + arr[curr][i], depth+1);
            visited[i] = false;
        }
    }

}
