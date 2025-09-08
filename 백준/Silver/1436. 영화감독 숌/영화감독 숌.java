import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i=666;
        while(true) {
            if(String.valueOf(i).contains("666")) {
                N--;
            }
            if(N==0) {
                break;
            }
            i++;
        }
        System.out.println(i);
    }
}
