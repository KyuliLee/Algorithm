import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // map의 key에는 숫자를, value에는 빈도를 저장
        // list에는 숫자를 저장
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            // map에서 n이 key로 존재하면 그 때의 value를 리턴, 만약 없으면 defaultValue인 0을 리턴
            int cnt = map.getOrDefault(n, 0);
            // map의 key에 n이 없으면 리스트에 넣고 map에도 빈도를 1로 넣는다.
            // 만약 있으면 map에서 빈도를 1 증가시켜서 넣는다.
            if(cnt==0) {
                list.add(n);
                map.put(n, 1);
            } else {
                map.put(n, cnt+1);
            }
        }

        // 리스트에 들어간 숫자를 빈도순(내림차순), 먼저 들어온 순으로 정렬
        list.sort((o1, o2) -> {
            // 리스트의 숫자에 해당하는 빈도를 num1, num2에 저장
            int num1 = map.get(o1);
            int num2 = map.get(o2);
            if(num1 == num2) {
                return 0;
            }
            return num2-num1;
        });

        StringBuilder sb = new StringBuilder();
        for(int key : list) {
            int freq = map.get(key);
            for(int i=0; i<freq; i++) {
                sb.append(key).append(" ");
            }
        }

        System.out.println(sb);
    }
}