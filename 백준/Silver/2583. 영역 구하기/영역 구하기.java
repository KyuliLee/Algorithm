import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Integer> areas = new PriorityQueue<>();
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 문제에서 M, N, K 순서로 주지만 첫 번째 숫자가 row에 해당하므로 걍 N이라 치자
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        /*
        사각형을 arr에 1로 저장. 못 감. arr가 0인 섬들의 넓이 찾기
         */
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            // 모눈종이를 상하를 뒤집었다고 생각 / 6, 2를 받으면 2가 row, 6이 column으로 생각.
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            for(int r=r1; r<r2; r++) {
                for(int c=c1; c<c2; c++) {
                    arr[r][c] = 1;
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1 || visited[i][j]) continue;

                visited[i][j] = true;
                int area = 1;
                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.offer(new int[] {i, j});

                while(!q.isEmpty()) {
                    int[] curr = q.poll();
                    for(int d=0; d<4; d++) {
                        int nr = curr[0]+dr[d];
                        int nc = curr[1]+dc[d];

                        if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]==1 || visited[nr][nc]) continue;
                        area++;
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc});
                    }
                }
                areas.offer(area);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append("\n");
        while(!areas.isEmpty()) {
            sb.append(areas.poll()).append(" ");
        }
        System.out.println(sb);

    }
}
