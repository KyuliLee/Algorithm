import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(n==1) {
            System.out.println("*");
            return;
        }

        for(int i=1; i<n; i++) {
            sb.append(" ");
        }
        sb.append("*").append("\n");
        for(int i=2; i<n; i++) {
            for(int j=1; j<=n-i; j++) {
                sb.append(" ");
            }
            sb.append("*");
            for(int j=1; j<=2*i-3; j++) {
                sb.append(" ");
            }
            sb.append("*");
            sb.append("\n");
        }

        for(int i=1; i<=2*n-1; i++) {
            sb.append("*");
        }

        System.out.println(sb);
    }
}
