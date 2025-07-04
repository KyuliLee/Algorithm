import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N];
        sum[0] = 0;

        for(int i=0; i<N; i++) {
            sum[i] = arr[i]; // arr[i] 전의 숫자들이 더 커도 arr[i]부터 시작하는 게 결국에는 더 커질 수 있음
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j] && sum[i] < sum[j]+arr[i]) {
                    sum[i] = sum[j] + arr[i];
                }
            }
        }

        int max = -1;
        for(int i=0; i<N; i++) {
            max = Math.max(max, sum[i]);
        }
        System.out.println(max);
    }
}
