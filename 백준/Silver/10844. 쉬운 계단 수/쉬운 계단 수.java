import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 1000000000;

        /* 풀이
        N = 1, 2, 3일 때까지 해보면 규칙을 알 수 있다.
        1. 일의 자리가 0인 경우에 다음 단계에서는 01만 가능하다
        2. 일의 자리가 1~8인 경우에 다음 단계에서는 10, 12, 21, 23, ..., 87, 89가 가능하다.
        3. 일의 자리가 9인 경우에 다음 단계에서는 98만 가능하다
        2차원 배열 생성. dp[a][b]는 길이가 a이고 끝자리가 b인 계단 수의 개수를 말한다.
         */

        long[][] dp = new long[N+1][10];
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int n=2; n<=N; n++) {
            for(int i=0; i<10; i++) {
                if(i==0) {
                    dp[n][1] += (dp[n-1][0]%mod);
                } else if(i==9) {
                    dp[n][8] += (dp[n-1][9]%mod);
                } else {
                    dp[n][i-1] += (dp[n-1][i]%mod);
                    dp[n][i+1] += (dp[n-1][i]%mod);
                }
            }
        }
        int num = 0;
        for(int i=0; i<10; i++) {
            num += (dp[N][i] % mod);
            num %= mod;
        }
        System.out.println(num%mod);
    }
}
