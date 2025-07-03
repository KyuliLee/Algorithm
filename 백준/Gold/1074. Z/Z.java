import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int ans = 0;

        for(int i=N; i>0; i--) {
            int half = (int)Math.pow(2, i-1);
            int block = half*half;

            // r, c가 1사분면에 있는 경우
            if(r<half && c>=half) {
                c -= half;
                ans += block;
            } else if(r>=half && c>=half) { // r, c가 2사분면에 있는 경우
                r -= half;
                c -= half;
                ans += 3*block;
            } else if(r>=half && c<half) { // r, c가 3사분면에 있는 경우
                r -= half;
                ans += 2*block;
            } else { // r, c가 4사분면에 있는 경우
                // 아무 일도 일어나지 않음
            }
        }
        System.out.println(ans);
    }


}
