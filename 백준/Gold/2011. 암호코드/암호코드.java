import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = str.charAt(i)-'0';
        }
        if(arr[0] == 0) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[N];
        dp[0] = 1;
        /*
        잘못된 암호인 경우 : 0으로 시작, 00, 30, 40, 50, 60, 70, 80, 90
        curr가 1~9인 경우 : 일단 나올 수 있는 해석의 수가 dp[i-1]과 동일
        prev가 1, 2일 때 prev*10+curr가 26 이하이면 dp[i-2]를 더함
        26 초과이면 넘어감
         */

        for(int i=1; i<N; i++) {
            int curr = arr[i];
            int prev = arr[i-1];
            if(prev == 0 && curr == 0) {
                System.out.println(0);
                return;
            }
            if(prev>=3 && prev<=9 && curr==0) {
                System.out.println(0);
                return;
            }
            if(curr>=1 && curr <=9) {
                dp[i] = dp[i-1];
            }

            if(prev*10+curr >=10 && prev*10+curr <= 26) {
                if(i==1) { // i가 1이면 i-2는 없으므로 직접 증가시켜줌
                    dp[i] = (dp[i]+1)%1000000;
                } else {
                    dp[i] = (dp[i] + dp[i-2])%1000000;
                }
            }
        }
        System.out.println(dp[N-1]);



    }
}
