import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 초기화 완료
        int[] dp = new int[N+1]; // dp[i] : 카드 i개를 살 때 지불하는 금액의 최댓값
        for(int i=1; i<=N; i++) { //
            for(int j=1; j<=i; j++) {
                dp[i] = Math.max(arr[j]+dp[i-j], dp[i]); // j개 묶음의 카드팩을 살 때 가격 + 카드 i-j개를 살 때 최대 가격과 dp[i] 비교
            }
        }
        System.out.println(dp[N]);
    }
}
