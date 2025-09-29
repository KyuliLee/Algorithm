import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int maxSafeArea = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0은 빈 칸, 1은 벽, 2는 바이러스. 벽을 꼭 3개를 세워서 안전 영역의 최댓값 구하기
        // 지도 크기가 최대 8X8로 작다.
        // dfs로 3개 벽을 세우기 -> bfs로 바이러스 확산 -> 안전한 칸 세기 -> 벽을 빈 칸으로 원복

        dfs(0);
        System.out.println(maxSafeArea);

    }
    static void dfs(int wallCnt) {
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wallCnt+1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        // 바이러스를 원본 배열에서 퍼뜨리면 안 되니까 copyMap 사용
        int[][] copyMap = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                copyMap[i][j] = arr[i][j];
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(arr[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];

                if(nr<1 || nr>N || nc<1 || nc>M) continue;
                if(copyMap[nr][nc] == 1 || copyMap[nr][nc]==2) continue;
                copyMap[nr][nc] = 2;
                q.offer(new int[] {nr, nc});
            }
        } // 바이러스 확산 완료

        int safeArea = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(copyMap[i][j] == 0) safeArea++;
            }
        }
        maxSafeArea = Math.max(maxSafeArea, safeArea);

    }
}
