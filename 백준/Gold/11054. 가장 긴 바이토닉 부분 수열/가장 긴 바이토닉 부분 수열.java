import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        int[] sum = new int[N];
        for(int i=0; i<N; i++) {
            dp1[i] = 1;

            // i를 마지막으로 하는 가장 긴 증가하는 부분수열
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i] && dp1[i] < dp1[j]+1) {
                    dp1[i] = dp1[j]+1;
                }
            }
            sum[i] = dp1[i];
        }
        for(int i=N-1; i>=0; i--) {
            dp2[i] = 1;
            // i부터 시작하는 가장 긴 감소하는 부분수열
            for(int j=N-1; j>i; j--) {
                if(arr[j] < arr[i] && dp2[i] < dp2[j]+1) {
                    dp2[i] = dp2[j]+1;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<N; i++) {
            ans = Math.max(ans, dp1[i]+dp2[i]);
        }
        System.out.println(--ans);

    }
}
