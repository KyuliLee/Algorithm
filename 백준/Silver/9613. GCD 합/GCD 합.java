import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long ans = 0;
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    ans += gcd(arr[i], arr[j]);
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

}