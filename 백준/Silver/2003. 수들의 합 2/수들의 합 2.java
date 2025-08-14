import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = 0;
        int sum = arr[0];

        while(right < N) {
            if(sum == M) {
                cnt++;
                right++;
                if(right==N) break;
                sum += arr[right];
            } else if(sum < M){
                right++;
                if(right==N) break;
                sum += arr[right];
            } else {
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(cnt);


    }

}
