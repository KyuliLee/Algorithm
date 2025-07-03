import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1]; // i자리 이친 수의 개수
        long[] dp0 = new long[N+1]; // i자리 수 중 0으로 끝나는 숫자의 개수
        long[] dp1 = new long[N+1]; // i자리 수 중 1로 끝나는 숫자의 개수

        if(N==1 || N==2) {
            System.out.println(1);
            return;
        }
        if(N==3) {
            System.out.println(2);
            return;
        }
        dp[1] = 1; // 1
        dp[2] = 1; // 10
        dp0[2] = 1;
        dp1[2] = 0;
        dp[3] = 2; // 100, 101
        dp0[3] = 1;
        dp1[3] = 1;
        for(int i=4; i<=N; i++) {
            // i-1자리 수의 끝자리 수가 0이었으면 i자리 수의 끝자리에는 1, 0 모두 가능
            dp0[i] = dp0[i-1];
            dp1[i] = dp0[i-1];
            // i-1자리 수의 끝자리 수가 1이었으면 i자리 수의 끝자리에는 0만 가능
            dp0[i] += dp1[i-1];

            dp[i] = dp1[i]+dp0[i];
        }

        System.out.println(dp[N]);
    }
}
