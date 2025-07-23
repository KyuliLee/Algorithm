import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[N+1]; // false값을 가지는 인덱스가 소수
        prime[0] = true;
        prime[1] = true;
        for(int i=2; i*i<=N; i++) {
            if(!prime[i]) {
                for(int j=i*i; j<=N; j+=i) {
                    prime[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++) {
            if(!prime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);

    }
}