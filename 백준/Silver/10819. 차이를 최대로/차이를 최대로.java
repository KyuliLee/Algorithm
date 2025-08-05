import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, ans;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ans = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        /*
        N개의 숫자를 순열로 나열
         */
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int depth) {
        if(depth == N) {
            int res = cal();
            if(res > max) {
                max = res;
            }
            return;
        }
        for(int i=0; i<N; i++) {
            if(visited[i]) {
               continue;
            }
            visited[i] = true;
            ans[depth] = arr[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }
    static int cal() {
        int res = 0;
        for(int i=0; i<N-1; i++) {
            res += Math.abs(ans[i]-ans[i+1]);
        }
        return res;
    }
}
