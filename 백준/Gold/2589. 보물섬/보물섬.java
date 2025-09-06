import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
class Pos {
    int r;
    int c;
    int dist;
    public Pos(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}
public class Main {
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int treasureDist = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        ArrayDeque<Pos> lands = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'L') {
                    lands.offer(new Pos(i, j, 0));
                }
            }
        }
        /*
        최단거리 중에 최장거리 찾기.
        L 위치를 큐에 넣어놓고 하나씩 빼면서 모든 L점에서부터 bfs를 하기.
        L 한 점부터 시작할 때마다 visited를 초기화
           bfs를 할 때는 arr가 L이고 방문 안 한 곳만 큐에 넣고 방문 처리.
           bfs가 끝나면 그 L 점에서의 최장거리와 treasureDist 비교
         */
        while(!lands.isEmpty()) {
            Pos startPoint = lands.poll();
            ArrayDeque<Pos> q = new ArrayDeque<>();
            q.offer(startPoint);
            visited = new boolean[N][M];
            visited[startPoint.r][startPoint.c] = true;
            int longest = 0;

            while(!q.isEmpty()) {
                Pos curr = q.poll();

                for(int d=0; d<4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || arr[nr][nc] == 'W') continue;

                    q.offer(new Pos(nr, nc, curr.dist+1));
                    visited[nr][nc] = true;
                    longest = Math.max(longest, curr.dist+1);
                }
            }
            treasureDist = Math.max(longest, treasureDist);
        }
        System.out.println(treasureDist);

    }
}
