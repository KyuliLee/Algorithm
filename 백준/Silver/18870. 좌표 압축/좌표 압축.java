import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        } // 초기화 완료
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        map.put(sorted[0], rank++);
        for(int i=1; i<N; i++) {
            if(sorted[i] == sorted[i-1]) {
                continue;
            } else {
                map.put(sorted[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int key = arr[i];
            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb);

    }
}
