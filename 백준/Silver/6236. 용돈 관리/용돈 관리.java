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
        int[] arr = new int[N];
        int max = 0;
        int total = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            total += arr[i];
        }

        int low = max; // 하루에 이용할 금액 만큼은 인출해야 한다
        int high = total; // K가 1일 때 하루 이용 금액들의 합을 인출해야 한다
        while(low < high) {
            int mid = (low+high)/2; // mid만큼 인출
            int sum = 0;
            int cnt = 1; // 인출 횟수

            for(int i=0; i<N; i++) {
                if(cnt > M) {
                    break;
                }
                sum += arr[i];
                if(sum > mid) {
                    sum = arr[i];
                    cnt++;
                }
            }
            if(cnt > M) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }
}