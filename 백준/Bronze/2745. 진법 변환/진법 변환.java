import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char[] charArr = str.toCharArray();
        int N = Integer.parseInt(st.nextToken());

        int len = charArr.length;
        int ans = 0;
        for(int i=0; i<charArr.length; i++) {
            char c = charArr[i];
            int n = c-'0';
            if(n<=9) {
                ans += n*Math.pow(N, --len);
            } else {
                ans += (n-7)*Math.pow(N, --len);
            }
        }
        System.out.println(ans);
    }

}