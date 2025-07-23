import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==0 || N==1) {
            System.out.println(1);
            return;
        }
        int ans = 1;
        for(int i=N; i>=2; i--) {
            ans *= i;
        }
        System.out.println(ans);

    }
}