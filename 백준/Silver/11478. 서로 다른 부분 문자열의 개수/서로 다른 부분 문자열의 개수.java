import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int len = S.length();
        char[] charArr = S.toCharArray();
        // String을 set에 넣기
        Set<String> set = new HashSet<>();
        int ans = 0;
        for(int s=0; s<len; s++) {
            StringBuilder sb = new StringBuilder();
            for(int e=s; e<len; e++) {
                // charArr[s]부터 charArr[e]까지의 char로 String을 만드는데 +로 만들면 시간초과날 듯
                sb.append(charArr[e]);
                String str = new String(sb);
                if(!set.contains(str)) {
                    set.add(str);
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
