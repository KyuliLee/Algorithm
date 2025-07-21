import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a < b) {
                int c = a;
                a = b;
                b = c;
            }
            if(a%b==0) {
                sb.append(a).append("\n");
            } else {
                sb.append(a*b/(gcd(a, b))).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int gcd(int a, int b) {
        while(b != 0) {
            int c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}