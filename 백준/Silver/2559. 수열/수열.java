import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 초기화 완료

        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i=0; i<K; i++) {
            curr += arr[i];
        }
        max = Math.max(max, curr);

        for(int i=0, j=K; j<N; j++) {
            curr -= arr[i++];
            curr += arr[j];
            max = Math.max(max, curr);
        }

        System.out.println(max);

    }
}