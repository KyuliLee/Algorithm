import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 초기화 완료

        // 윗줄에서 내려오는 값과 왼쪽에서 오는 값 비교, 윗줄 값과 오른쪽 값 비교해서 큰 값을 dp에 저장
        int[][] dp = new int[N][M];
        // [0][0]에서 시작하므로 dp의 0번 row는 왼쪽에서 올 수밖에 없다.
        dp[0][0] = arr[0][0];
        for(int i=1; i<M; i++) {
            dp[0][i] = dp[0][i-1]+arr[0][i];
        }

        // 0번 row는 위에서 오는 값, 왼쪽에서 오는 값 비교
        // 1번 row는 위에서 오는 값, 오른쪽에서 오는 값 비교
        int[][] tmp = new int[2][M];
        for(int i=1; i<N; i++) {
            // 0번 row에 값 넣기
            tmp[0][0] = dp[i-1][0] + arr[i][0];
            for(int j=1; j<M; j++) {
                tmp[0][j] = Math.max(dp[i-1][j], tmp[0][j-1]) + arr[i][j];
            }

            // 1번 row에 값 넣기
            tmp[1][M-1] = dp[i-1][M-1] + arr[i][M-1];
            for(int j=M-2; j>=0; j--) {
                tmp[1][j] = Math.max(dp[i-1][j], tmp[1][j+1]) + arr[i][j];
            }

            // 0번 row와 1번 row 중 큰 값을 dp에 넣기
            for(int j=0; j<M; j++) {
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}