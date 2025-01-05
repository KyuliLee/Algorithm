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
        int[] best = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            best[i] = 1;

            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j] && best[i] < best[j]+1) {
                    best[i] = best[j]+1;
                }
            }
        }

        System.out.println(Arrays.stream(best).max().getAsInt());
    }
}