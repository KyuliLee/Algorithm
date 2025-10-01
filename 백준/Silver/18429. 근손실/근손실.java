import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, cnt = 0;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(cnt);
    }
    static void dfs(int depth, int sum) {
        if(depth == N) {
            cnt++;
            return;
        }
        if(sum < 0) return; // 백트래킹.
        for(int i=0; i<N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(depth+1, sum+arr[i]-K);
            visited[i] = false;
        }
    }
}
