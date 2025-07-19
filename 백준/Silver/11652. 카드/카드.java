import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            Long n = Long.parseLong(br.readLine());
            if(map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }

        int maxCnt = -1;
        long num = 0;
        for(Long k : map.keySet()) {
            int v = map.get(k);
            if(maxCnt < v) {
                maxCnt = v;
                num = k;
            } else if(maxCnt == v) {
                if(num > k) {
                    num = k;
                }
            }
        }
        System.out.print(num);

    }
}