import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Stone implements Comparable<Stone> {
        int m;
        int v;
        Stone(int m, int v) {
            this.m = m;
            this.v = v;
        }
        @Override
        public int compareTo(Stone o) {
            // 정렬 시 무게에 대해 오름차순
            if(this.m != o.m) {
                return this.m - o.m;
            }
            // 무게가 같다면 가격에 대해 내림차순
            return o.v - this.v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1. 보석을 무게 오름차순, 가격 내림차순으로 정렬
        // 2. 작은 가방부터 보석 넣기 위해 무게 오름차순으로 정렬
        // 3. 모든 가방에 대해 반복문을 수행
            // 1) 가방 크기보다 무게가 작거나 같은 모든 보석을 우선순위큐에 넣는다. 우선순위큐는 가격 내림차순이다.
            // 2) 우선순위큐에서 보석 하나를 빼서 ans에 보석 가격을 더한다.
                // 해당 가방의 크기에 담을 보석이 없을 때를 고려해서 우선순위큐가 비어있지 않을 때만 우선순위큐에서 보석을 빼서 ans에 더한다.
        Stone[] stones = new Stone[N];
        int[] bags = new int[K];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 보석의 무게
            int v = Integer.parseInt(st.nextToken()); // 보석의 가격
            stones[i] = new Stone(m, v);
        }
        Arrays.sort(stones);

        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // 가방 오름차순 정렬
        Arrays.sort(bags);
        // 보석 가격 기준 내림차순 정렬
        PriorityQueue<Stone> pq = new PriorityQueue<>((s1, s2) -> {
            return s2.v - s1.v;
        });

        int stoneIdx = 0;
        long ans = 0;
        for(int i=0; i<K; i++) {
            while(stoneIdx < N && stones[stoneIdx].m <= bags[i]) {
                pq.offer(stones[stoneIdx++]);
            }
            if(!pq.isEmpty()) {
                ans += pq.poll().v;
            }
        }
        System.out.println(ans);
    }
}