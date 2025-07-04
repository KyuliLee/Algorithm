import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];

            if(n==1) {
                System.out.println(1);
                continue;
            }
            if(n==2) {
                System.out.println(2);
                continue;
            }
            if(n==3) {
                System.out.println(4);
                continue;
            }
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            for(int i=4; i<=n; i++) {
                arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
            }
            System.out.println(arr[n]);
        }
    }
}
