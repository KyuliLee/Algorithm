import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[2][N+1];
        if(N==1) {
            System.out.println(1);
            return;
        }
        if(N==2) {
            System.out.println(1);
            return;
        }
        if(N==3) {
            System.out.println(2);
            return;
        }
        arr[0][3] = 1;
        arr[1][3] = 1;
        for(int i=4; i<=N; i++) {
            arr[0][i] = arr[0][i-1] + arr[1][i-1];
            arr[1][i] = arr[0][i-1];
        }
        System.out.println(arr[0][N] + arr[1][N]);
    }
}
