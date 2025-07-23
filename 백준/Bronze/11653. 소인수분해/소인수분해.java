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
        if(N==1) {
            return;
        }
        /* 소인수분해
        prime 배열을 만들고 인덱스를 증가시켜가면서 소수를 만나면 그 소수를 sb에 append, N을 그 소수로 나누고 0이 될 때까지 반복
         */
        boolean[] prime = new boolean[N+1];
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
        while(N>1) {
            for(int i=2; i<=N; i++) {
                if(N%i==0 && !prime[i]) {
                    sb.append(i).append("\n");
                    N/=i;
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}