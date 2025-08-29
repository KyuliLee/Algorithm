import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                arr[r][c] = 1;
            }
            visited = new boolean[N][M];

            // 배추섬 몇 개 있는지 찾기
            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int r, int c) {
        visited[r][c] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int d=0; d<4; d++) {
                int nr = curr[0]+dr[d];
                int nc = curr[1]+dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
                if(arr[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }

    }

}
