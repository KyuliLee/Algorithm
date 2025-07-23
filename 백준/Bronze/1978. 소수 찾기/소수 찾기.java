import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] prime = new boolean[1001];
        for(int i=2; i<=1000; i++) {
            if(!prime[i]) {
                for(int j=2; i*j<=1000; j++) {
                    prime[i*j] = true;
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<N; i++) {
            int n = arr[i];
            if(n==1) {
                continue;
            }
            if(!prime[n]) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}