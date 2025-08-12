import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());



        int res = 0;
        int max = (int) Math.pow(2, N);
        while(max > 1) {
            int half = max /2;
            int chunk = half*half;
            if(r>=0 && r< half && c>=0 && c< half) {
                max /= 2;
            } else if(r>=0 && r< half && c>= half && c< max) {
                res += chunk;
                c -= half;
            } else if(r>= half && r< max && c>=0 && c< half) {
                res += chunk*2;
                r -= half;
            } else {
                res += chunk*3;
                r -= half;
                c -= half;
            }
        }

        System.out.println(res);
    }
}
