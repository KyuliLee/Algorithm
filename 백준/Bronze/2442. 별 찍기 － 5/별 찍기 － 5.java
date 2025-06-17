import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int z=1; z<=n; z++) {
            for(int i=1; i<=n-z; i++) {
                sb.append(" ");
            }
            for(int i=1; i<=2*z-1; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
