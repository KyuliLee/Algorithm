import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int TC=1; TC<=tc; TC++) {
            // 의상 이름은 중복이 아니므로 저장할 필요 없음.
            // 해당 카테고리에 의상이 몇 개인지만 저장하면 됨
            // 카테고리 2개에 의상이 1, 2개 있다면 의상 1, null, 의상 1, 2, null 로 생각해서
            // 2*3 에서 null, null인 경우 1개만 빼주면 됨
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상 이름은 저장 안 함
                String thisCategory = st.nextToken();

                // 만약 이번 카테고리가 hashmap에 있다면 value만 1 더함
                if(map.containsKey(thisCategory)) {
                    map.put(thisCategory, map.get(thisCategory)+1);
                } else { // 만약 없다면 key를 넣어줌
                    map.put(thisCategory, 1);
                }
            }
            int result = 1;
            for(int v : map.values()) {
                result *= (v+1);
            }
            System.out.println(result-1);

        }
    }
}