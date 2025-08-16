import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prime = new boolean[N+1];
        prime[0] = true;
        prime[1] = true;
        for(int i=2; i*i<=N; i++) {
            for(int j=i*i; j<=N; j += i) {
                if(prime[j]) continue;
                prime[j] = true;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            if(!prime[i]) {
                list.add(i);
            }
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while(true) {
            if(sum < N) {
                if(right == list.size()) break;
                sum += list.get(right);
                right++;
            } else {
                if(sum == N) {
                    cnt++;
                }
                sum -= list.get(left);
                left++;
                if(left > right) break;
            }
        }

        System.out.println(cnt);
    }
}
