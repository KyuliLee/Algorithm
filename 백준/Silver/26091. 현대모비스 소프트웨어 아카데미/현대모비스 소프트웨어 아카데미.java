import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N==1) {
            System.out.println(0);
            return;
        }
        /*
        정렬 후 맨 앞, 맨 뒤부터 2명씩 점수 더함
         */
        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        int cnt = 0;
        while(start < end) {
            long sum = arr[start] + arr[end];
            if(sum >= M) {
                cnt++;
                start++;
                end--;
            } else {
                start++;
            }
        }
        System.out.println(cnt);
    }
}
