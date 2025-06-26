import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int n=N; n>0; n--) {
            for(int i=0; i+n < N; i++) {
                sb.append(" ");
            }
            for(int i=0; i<2*n-1; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
