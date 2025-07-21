import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long gcd = gcd(A, B);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=gcd; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }
    public static long gcd(long a, long b){
        while (b!=0) {
            long c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

}