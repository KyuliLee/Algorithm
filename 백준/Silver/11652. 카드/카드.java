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
        /*
        map의 key들을 돌면서 value가 클 때를 구함
        maxCnt는 현재까지 가장 많이 갖고 있는 정수 카드의 값.
        maxCnt와 이번 value를 비교하면서 만약 value가 더 크면 maxCnt 갱신, pq 클리어하고 key넣기
        만약 maxCnt와 이번 value가 같다면 pq에 key 넣기
         */
        int maxCnt = -1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(Long k : map.keySet()) {
            int v = map.get(k);
            if(maxCnt < v) {
                maxCnt = v;
                pq.clear();
                pq.offer(k);
            } else if(maxCnt == v) {
                pq.offer(k);
            }
        }
        System.out.print(pq.poll());

    }
}
