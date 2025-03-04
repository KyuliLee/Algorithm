import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 컬럼 개수
            N = Integer.parseInt(st.nextToken()); // 행 개수
            K = Integer.parseInt(st.nextToken()); // 배추 위치 개수
            cnt = 0; // 배추흰지렁이 마리 수
            arr = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[Y][X] = 1;
            }

            // 0인 곳으로 못 가게 방문 처리
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] == 0) {
                        visited[i][j] = true;
                    }
                }
            }

            // 1인 점 찾아서 마리 수 cnt
            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int d=0; d<4; d++) {
                int nr = curr[0]+dr[d];
                int nc = curr[1]+dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M) {
                    continue;
                }
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}