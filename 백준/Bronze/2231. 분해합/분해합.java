import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i=0;
        while(true) {
            i++;
            int num = i;
            int sum = i;
            while(num > 0) {
                int temp = num % 10;
                sum += temp;
                num /= 10;
            }
            if(sum == N) {
                break;
            }
            if(i > 1000000) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(i);
    }
}
