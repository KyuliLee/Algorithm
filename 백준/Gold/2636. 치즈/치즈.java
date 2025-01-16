import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int t = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) { // 치즈 칸 개수 세기
                    cnt++;
                }
            }
        } // 초기화 완료
        bfs();
    }
    static void bfs() {
        // 1시간에 bfs를 한 번 실행
        // 사방탐색 하면서 0이면 큐에 넣음, 1이면 0으로 갱신하고 melted 증가
        t++;
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        int melted = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            for(int d=0; d<4; d++) {
                int nr = currR+dr[d];
                int nc = currC+dc[d];
                if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc]) continue;
                visited[nr][nc] = true;

                if(arr[nr][nc] == 0) {
                    q.offer(new int[] {nr, nc});
                } else {
                    arr[nr][nc] = 0;
                    melted++;
                }
            }
        }

        cnt -= melted;
        if(cnt == 0) {
            System.out.println(t);
            System.out.println(melted);
            return;
        }
        bfs();
    }
}