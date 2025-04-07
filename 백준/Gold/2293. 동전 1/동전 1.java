import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // dp : i원을 만들 수 있는 경우의 수
        // dp[j]는 이전의 dp[j]값에서 이번 동전 값을 뺐을 때의 dp값을 더한다.
        // 왜냐하면, dp[j]는 0, 1, ..., i-1번째의 동전을 사용했을 때까지 j원을 만들 수 있는 경우의 수
        // coins[i]를 사용한다면 j-coins[i]원을 만드는 경우의 수 각각에 coins[i]를 한 번만 더 사용하면 되는 거니까
        // 그 때의 dp값 (dp[j-coins[i]])을 더한다.
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=k; j++) {
                if(j<coins[i]) {
                    continue;
                }
                dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}