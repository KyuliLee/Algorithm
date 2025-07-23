import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] prime = new boolean[1000001];
        prime[0] = true;
        prime[1] = true;

        for(int i=2; i*i<=1000000; i++) {
            if(!prime[i]) {
                for(int j=i*i; j<=1000000; j+=i) {
                    prime[j] = true;
                }
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            /*
            두 수를 더해서 n을 만드는 방법 구하기. n을 만들 수 있는 방법이 2개 이상이라면 b-a가 최대인 것을 출력
            b를 점점 내려가면서 b, a가 모두 소수인 경우 구하기
             */
            boolean flag = false;

            int a = 0;
            int b = 0;
            for(b=n-3; b>=3; b--) {
                // a, b 모두 소수이면 n을 만들 수 있음
                if(prime[b]) {
                    continue;
                }
                a = n-b;
                if(prime[a]) {
                    continue;
                }
                flag = true;
                break;
            }

            if(flag) {
                sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
            } else {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
            n = Integer.parseInt(br.readLine());
        }
        System.out.print(sb);
    }
}