import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 초기화 완료

        /* 풀이
        start, end 인덱스를 잡아서 start~end의 합이 S보다 작으면 end를 1 증가시킨다.
        S보다 크거나 같으면 그 길이를 저장하고 start를 1 증가시킨다.
         */

        if(arr[0] >= S) {
            System.out.println(1);
            return;
        }

        int start = 0;
        int end = 1;
        int sum = arr[start] + arr[end];
        int ans = Integer.MAX_VALUE;
        while(true) {
            if(end == N) {
                break;
            }
            if(sum < S) {
                end++;
                if(end == N) {
                    break;
                }
                sum += arr[end];
            } else if(sum >= S) {
                if (end - start + 1 < ans) {
                    ans = end - start + 1;
                }
                sum -= arr[start];
                start++;
            }
        }
        if(ans < Integer.MAX_VALUE) {
            System.out.println(ans);
        } else {
            System.out.println(0);
        }

    }
}
