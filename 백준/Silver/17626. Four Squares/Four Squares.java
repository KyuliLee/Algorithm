import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] res = new int[N+1];
        if(N==1) {
            System.out.println(1);
            return;
        }
        res[1] = 1;
        // N이 2라면 1^2 + 1^2로 제곱수 2개로 표현 가능
        // N이 3이라면 1^2 + 1^2 + 1^2로 제곱수 3개로 표현 가능
        // N이 4라면 1^2 + 1^2 + 1^2 + 1^2 도 되지만 2^2도 되므로 제곱수 1개로 표현 가능
            // N이 5라면 1^2 + 2^2로 제곱수 2개로 표현 가능
            // N이 6이라면 1^2 + 1^2 + 2^2로 제곱수 3개로 표현 가능
            // N이 7이라면 1^2 + 1^2 + 1^2 + 2^2로 제곱수 4개로 표현 가능
            // N이 8이라면 2^2 + 2^2로 제곱수 2개로 표현 가능
            // N이 9라면 1^2 + 2^2 + 2^2 도 되지만 3^2도 되므로 제곱수 1개로 표현 가능
        // N에 대해서 루트N 의 숫자까지 확인
        // res[N]은 res[N-1]+1 일 수도 있고, 더 작을 수도 있다.
        // res[i-(j*j)]는 현재 숫자 i에서 j로 만든 제곱수를 뺐을 때의 숫자가 제곱수 몇 개로 표현 가능한지를 나타냄
        for(int i=2; i<=N; i++) {
            res[i] = res[i-1];
            for(int j=1; j*j<=i; j++) {
                res[i] = Math.min(res[i], res[i-(j*j)]);
            }
            res[i]++;
        }
        System.out.println(res[N]);
    }
}