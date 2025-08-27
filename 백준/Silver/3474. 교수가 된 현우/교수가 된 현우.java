import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            while (N >= 5) {
                count += N / 5;
                N /= 5;
            }

            sb.append(count).append("\n");

        }
        System.out.println(sb);
    }
}
