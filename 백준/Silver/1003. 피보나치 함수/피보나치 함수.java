import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        int max = 1; // 현재까지 표를 채워넣은 인덱스
        for(int tc=0; tc<TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            if(N>1) {
                for(int i=2; i<=N; i++) {
                    dp[i][0] = dp[i-1][0] + dp[i-2][0];
                    dp[i][1] = dp[i-1][1] + dp[i-2][1];
                }
            }
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.println(sb);
    }

}