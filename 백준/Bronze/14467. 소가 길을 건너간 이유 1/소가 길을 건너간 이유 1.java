import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cows = new int[11];
        for(int i=1; i<=10; i++) {
            cows[i] = -1;
        }
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(cows[cow] == -1) {
                cows[cow] = n;
                continue;
            }
            if(cows[cow] == 1 && n == 0) {
                cnt++;
                cows[cow] = 0;
            } else if(cows[cow] == 0 && n == 1) {
                cnt++;
                cows[cow] = 1;
            }

        }
        System.out.println(cnt);
    }
}
