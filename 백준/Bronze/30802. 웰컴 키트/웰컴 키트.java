import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());
        int tshirt = 0;
        for(int i=0; i<6; i++) {
            int n = Integer.parseInt(st.nextToken());
            tshirt += n/T;
            if(n%T != 0) {
                tshirt++;
            }
        }
        int penGroup = N/P;
        int penEach = N%P;
        System.out.println(tshirt);
        System.out.print(penGroup + " " + penEach);
    }
}
