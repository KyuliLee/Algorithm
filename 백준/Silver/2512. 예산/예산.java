import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) {
                max = arr[i];
            }
            sum += arr[i];
        }
        int M = Integer.parseInt(br.readLine());
        if(sum <= M) {
            System.out.println(max);
            return;
        } // 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정하고 리턴

        int min = 0;
        int answer = 0;
        while(min <= max) {
            int mid = (min+max)/2;
            int total = 0;
            for(int i=0; i<N; i++) {
                if(mid>arr[i]) {
                    total += arr[i];
                } else {
                    total += mid;
                }
            }
            // 현재까지 계산한 예산이 M보다 작으니까 min 키우기
            if(total <= M) {
                answer = mid;
                min = mid+1;
            } else { // 현재까지 계산한 예산이 M과 같거나 크다면 max 줄이기
                max = mid-1;
            }

        }
        System.out.println(answer);
    }
}