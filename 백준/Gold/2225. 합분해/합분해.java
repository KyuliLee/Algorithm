import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // K개의 수를 더해서 N을 만드는 경우의 수 구하기
        int[][] dp = new int[K+1][N+1]; // dp[a][b]는 a개의 수를 이용해 b를 만드는 경우의 수
        // 1개의 수를 이용해 N을 만드는 경우의 수는 1개
        for(int i=0; i<=N; i++) {
            dp[1][i] = 1;
        }
        // K개의 수를 이용해 0을 만드는 경우의 수는 1개 (0+0+...+0)
        for(int i=0; i<=K; i++) {
            dp[i][0] = 1;
        }
        // a개의 수를 사용해 b를 만드는 경우의 수
        for(int a=1; a<=K; a++) {
            for(int b=1; b<=N; b++) {
                dp[a][b] = (dp[a-1][b] + dp[a][b-1])%1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }
}
