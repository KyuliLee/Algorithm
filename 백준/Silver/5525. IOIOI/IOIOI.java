import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int K = 2*N+1;
        int cnt = 0;
        // 인덱스가 M-2*N+1이하일 때까지 arr를 돌면서 I를 만나면 i<= <i+2*N-1 범위에서 I와 O가 번갈아 나오는지 확인
        for(int i=0; i<=M-K; i++) {
            if(arr[i] == 'I') {
                // i가 홀수이면 홀수번째 자리가 I, 짝수번째 자리가 O / i가 짝수이면 짝수번째 자리가 I, 홀수번째 자리가 O여야 함
                boolean isOdd = false;
                if(i%2 == 1) isOdd = true;
                boolean flag = true;
                if(isOdd) {
                    for (int j = i; j < i + K; j++) {
                        if(j%2 == 1 && arr[j] == 'I') continue;
                        if(j%2 == 0 && arr[j] == 'O') continue;
                        flag = false;
                        break;
                    }
                } else {
                    for (int j = i; j < i + K; j++) {
                        if(j%2 == 1 && arr[j] == 'O') continue;
                        if(j%2 == 0 && arr[j] == 'I') continue;
                        flag = false;
                        break;
                    }
                }

                if(flag) cnt++;
            }
        }
        System.out.println(cnt);

    }
}
