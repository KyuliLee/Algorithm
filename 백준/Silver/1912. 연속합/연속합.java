import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int maxNum = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > maxNum) {
                maxNum = arr[i];
            }
        } // 초기화 완료

        int[] dp = new int[N];
        dp[0] = arr[0];
        int max = arr[0];

        for(int i=1; i<N; i++) {
            if(dp[i-1]+arr[i] > arr[i]){
                dp[i] = dp[i-1]+arr[i];
            } else {
                dp[i] = arr[i];
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
