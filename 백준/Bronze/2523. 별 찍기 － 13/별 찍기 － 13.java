import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int n=1; n<=N; n++) {
            for(int i=1; i<=n; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int n=N-1; n>=1; n--) {
            for(int i=1; i<=n; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
