import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int left = 1;
        int right = M;
        int J = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int j=0; j<J; j++) {
            int apple = Integer.parseInt(br.readLine());
            if(apple < left) {
                ans += (left - apple);
                left = apple;
                right = left + M - 1;
            } else if(apple > right) {
                ans += (apple - right);
                right = apple;
                left = (right - M) + 1;
            }
        }
        System.out.println(ans);
    }
}
