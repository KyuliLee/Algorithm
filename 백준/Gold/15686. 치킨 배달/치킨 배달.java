import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int H = 0, K = 0;
    static int[][] houses, chickens;
    static int[][] dist; // [house][chicken]의 거리
    static int[] pick;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houses = new int[2*N][2]; // 문제에서 2N개를 넘지 않는다고 했음
        chickens = new int[13][2]; // 문제에서 치킨집 최대 13개라고 했음
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if(v == 1) {
                    houses[H][0] = i;
                    houses[H][1] = j;
                    H++;
                } else if(v == 2) {
                    chickens[K][0] = i;
                    chickens[K][1] = j;
                    K++;
                }
            }
        }
        dist = new int[H][K];
        for(int i=0; i<H; i++) {
            int hr = houses[i][0];
            int hc = houses[i][1];
            for(int j=0; j<K; j++) {
                int cr = chickens[j][0];
                int cc = chickens[j][1];
                dist[i][j] = Math.abs(hr-cr) + Math.abs(hc-cc);
            }
        }

        pick = new int[M];

        // K개 중에서 M개 뽑기
        dfs(0, 0);

        System.out.println(min);

    }
    static void dfs(int start, int depth) {
        if(depth == M) {
            int cityChickenDist = 0;

            for(int h=0; h<H; h++) {
                // 이 집의 치킨 거리 구하기
                int chickenDist = Integer.MAX_VALUE;
                for(int m=0; m<M; m++) {
                    int chickenIdx = pick[m];
                    chickenDist = Math.min(chickenDist, dist[h][chickenIdx]);
                }
                cityChickenDist += chickenDist;
                if(chickenDist > cityChickenDist) {
                    return;
                }
            }
            min = Math.min(min, cityChickenDist);

            return;
        }
        for(int i=start; i<K; i++) {
            pick[depth] = i;
            dfs(i+1, depth+1);
        }
    }

}
