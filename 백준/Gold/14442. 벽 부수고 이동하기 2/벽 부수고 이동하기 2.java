import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static int[][][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M]; // 0은 이동 가능, 1은 벽
        dist = new int[K + 1][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int w = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r == N-1 && c == M-1) {
                System.out.println(dist[w][N-1][M-1]+1);
                return;
            }

            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M)  continue;

                if(arr[nr][nc] == 0 && dist[w][nr][nc] == 0) { // 다음 위치가 0이고 아직 방문 안 했으면 이동
                    dist[w][nr][nc] = dist[w][r][c]+1;
                    q.offer(new int[] {w, nr, nc});
                } else if(arr[nr][nc] == 1) { // 다음 위치가 벽
                    if(w == K) continue; // 이미 K개의 벽을 다 부순 경우 넘어감
                    else { // 아직 벽을 K개까지 안 부순 경우
                        if(dist[w+1][nr][nc] == 0) { // 벽 부순 위치를 아직 방문 안 했다면 부수고 이동
                            dist[w+1][nr][nc] = dist[w][r][c]+1;
                            q.offer(new int[] {w+1, nr, nc});
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
