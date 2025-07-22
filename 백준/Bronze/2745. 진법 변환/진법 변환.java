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
        int exponential = len-1;
        for(int i=0; i<len; i++) {
            int n = 0;
            if(charArr[i] >= 65) { // A 이상이라면
                n = charArr[i]-55;
            } else {
                n = charArr[i]-48;
            }
            ans += n*Math.pow(N, exponential--);
        }
        System.out.println(ans);
    }

}