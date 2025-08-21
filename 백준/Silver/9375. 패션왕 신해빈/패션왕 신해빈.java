import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for(int tc=0; tc<TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();
                map.put(category, map.getOrDefault(category, 0)+1);
            }
            int res = 1;
            for(int v : map.values()) {
                res *= (v+1);
            }
            res--;
            System.out.println(res);
        }
    }
}
