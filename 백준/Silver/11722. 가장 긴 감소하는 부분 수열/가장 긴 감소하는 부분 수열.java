import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 초기화 완료
        int[] dp = new int[N];

        int max = -1;
        for(int n=0; n<N; n++) {
            dp[n] = 1;
            for(int i=0; i<n; i++) {
                if(arr[i] > arr[n]) {
                    dp[n] = Math.max(dp[i]+1, dp[n]);
                }
            }
            max = Math.max(max, dp[n]);
        }
        System.out.println(max);
    }
}
