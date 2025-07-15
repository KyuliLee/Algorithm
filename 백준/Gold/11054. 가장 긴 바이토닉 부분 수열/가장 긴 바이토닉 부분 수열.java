import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 초기화 완료
        int[] dp1 = new int[N]; // 가장 긴 증가하는 부분 수열 길이 구하기
        int[] dp2 = new int[N]; // 역순으로 봤을 때 가장 긴 증가하는 부분 수열 길이 구하기
        // dp1, dp2 더해서 제일 큰 값 구하기.
        // 그 값에서 1 뺌. 해당 i는 두 번 들어갔으니까

        for(int n = 0; n <N; n++) {
            dp1[n] = 1;
            for(int i=0; i<n; i++) {
                if(arr[i] < arr[n]) {
                    dp1[n] = Math.max(dp1[n], dp1[i]+1);
                }
            }
        }

        for(int n=N-1; n>=0; n--) {
            dp2[n] = 1;
            for(int i=N-1; i>n; i--) {
                if(arr[n] > arr[i]) {
                    dp2[n] = Math.max(dp2[n], dp2[i]+1);
                }
            }
        }

        int ans = -1;
        for(int i=0; i<N; i++) {
            ans = Math.max(ans, dp1[i]+dp2[i]);
        }
        System.out.println(ans-1);


    }
}
