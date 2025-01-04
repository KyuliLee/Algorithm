import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        long max = 0;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) {max = arr[i];}
        } // 초기화, 최댓값 찾기 완료

        max++;
        
        long min = 0;
        while(min < max) {
            long mid = min + (max-min)/2;
            int cnt = 0;
            for(int i=0; i<K; i++) {
                cnt += arr[i]/mid;
            }
            if(cnt < N) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        System.out.println(min-1);

    }
}