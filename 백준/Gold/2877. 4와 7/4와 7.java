import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        K++;

        String binary = Integer.toBinaryString(K);
        String str = binary.substring(1);

        // 0->4, 1->7로 변환
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for(char c : arr) {
            sb.append(c=='0' ? '4' : '7');
        }

        System.out.println(sb);
    }
}