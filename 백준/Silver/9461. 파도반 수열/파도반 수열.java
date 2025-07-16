import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        int lastIdx = 3;
        for(int tc=1; tc<=TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            if(N > lastIdx) {
                for(int i=4; i<=N; i++) {
                    arr[i] = arr[i-2]+arr[i-3];
                }
                lastIdx = N;
            }
            System.out.println(arr[N]);
        }
    }
}
