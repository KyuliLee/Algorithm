import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        /*
        입력받을 때 nameMap, numberMap 둘 다에 키-밸류 쌍을 넣고 문제에서 숫자를 주면 numberMap에서, 이름을 주면 nameMap에서 찾기
         */
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numberMap = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            nameMap.put(str, i);
            numberMap.put(i, str);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String str = br.readLine();
            char c = str.charAt(0);
            if((c>='A' && c<='Z') || (c>='a' && c<='z')) {
                sb.append(nameMap.get(str)).append("\n");
            } else {
                sb.append(numberMap.get(Integer.parseInt(str))).append("\n");
            }
        }
        System.out.print(sb);

    }
}
