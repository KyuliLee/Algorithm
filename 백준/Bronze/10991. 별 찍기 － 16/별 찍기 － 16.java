import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int row=0; row<N; row++) {
            int starNum = row+1;
            for(int i=1; i<=N-starNum; i++) {
                sb.append(" ");
            }
            for(int i=0; i<starNum; i++) {
                sb.append("*").append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
