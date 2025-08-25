import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, C;
    static ArrayList<int[]> houses, chickens;
    static int[][] dist;
    static int[] ans;
    static int chickenDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];
        H = 0;
        C = 0;
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        /*
        0은 빈 칸, 1은 집, 2는 치킨집
        치킨집 개수는 최대 M개라고 해서 M개 이하도 가능하지만, 치킨거리가 최소가 되게 하기 위해서는 치킨집 개수가 최대여야 한다.
        집 개수를 H, 치킨집 개수를 C라고 하자.
        C개의 치킨집 중 M개를 골라서 치킨 거리가 최소가 될 때를 찾자 <- 조합
        미리 i번째 집과 j번째 치킨집 사이의 거리를 dist[i][j]에 저장해놓고 M개를 고를 때마다 도시의 치킨 거리 구하기.
            집, 치킨집을 입력받을 때마다 ArrayList에 int[] 로 r, c 저장하고 H개의 집과 C개의 치킨집을 돌면서 dist[i][j] 저장
            1~H번째 집에서 1~M번째 치킨집과의 최소 거리 찾아서 더하기
         */
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) {
                    H++;
                    houses.add(new int[] {i, j});
                } else if(n == 2) {
                    C++;
                    chickens.add(new int[] {i, j});
                }
            }
        }

        dist = new int[H][C]; // dist[i][j]가 i번째 집과 j번째 치킨집의 거리.

        // dist 구하기
        for(int i=0; i< houses.size(); i++) {
            int[] housePos = houses.get(i);
            int hr = housePos[0];
            int hc = housePos[1];
            for(int j=0; j< chickens.size(); j++) {
                int[] chickenPos = chickens.get(j);
                int cr = chickenPos[0];
                int cc = chickenPos[1];
                dist[i][j] = Math.abs(hr-cr) + Math.abs(hc-cc);
            }
        }

        // 치킨집 C 개 중에서 M 개 고르기
        dfs(0, 0);

        System.out.println(chickenDist);

    }
    static void dfs(int start, int depth) {
        if(depth == M) {

            // i번째 집과 M개의 치킨집을 돌면서 최소 치킨거리 찾기
            int currChickenDist = 0;
            for(int i=0; i<H; i++) {
                int currHouseMinDist = Integer.MAX_VALUE;
                for(int m=0; m<M; m++) {
                    int chicken = ans[m];
                    currHouseMinDist = Math.min(currHouseMinDist, dist[i][chicken]);
                }
                currChickenDist += currHouseMinDist;
            }
            chickenDist = Math.min(chickenDist, currChickenDist);

            return;
        }
        for(int i=start; i<C; i++) {
            ans[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}
