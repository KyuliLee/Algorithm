import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /* 풀이
        N=1 일 때는 10
        0 1 2 3 4 5 6 7 8 9
        N=2 일 때는 55
        00 01 02 03 04 05 06 07 08 09 -> 10
        11 12 13 14 15 16 17 18 19 -> 9
        22 23 24 25 26 27 28 29 -> 8
        -> 7 -> 6 -> ...
        99 -> 1
        dp[a][b]의 값이 c이다 : 길이가 a인 오르막 수 중 b로 끝나는 숫자는 c 개이다.
         */
        int[][] dp = new int[N+1][10];
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }


        for(int n=2; n<=N; n++) {
            for(int i=0; i<10; i++) {
                // 이전 단계의 끝자리 수가 i였으면 이번 단계에서 i부터 9로 끝나는 방에 이전 단계의 끝자리 수가 i인 방의 값을 다 더해줌
                for(int j=i; j<10; j++) {
                    dp[n][j] += (dp[n-1][i]%10007);
                }
            }
        }

        int sum = 0;
        for(int i=0; i<10; i++) {
            sum += (dp[N][i]%10007);
            sum %= 10007;
        }
        System.out.println(sum);

    }
}
