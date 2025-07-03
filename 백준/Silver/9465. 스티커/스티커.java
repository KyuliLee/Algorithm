import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=0; tc<TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];
            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 초기화 완료
            if(n==1) {
                System.out.println(Math.max(arr[0][0], arr[1][0]));
                continue;
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = arr[1][0]+arr[0][1];
            dp[1][1] = arr[0][0]+arr[1][1];

            if(n==2) {
                System.out.println(Math.max(dp[0][1], dp[1][1]));
            } else {
                for(int i=2; i<n; i++) {
                    dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                    dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
                }
                System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
            }
        }
    }
}