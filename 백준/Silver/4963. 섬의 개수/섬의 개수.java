import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    // 가로, 세로, 대각선 탐색
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) {
                break;
            }
            int[][] arr = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                }
            }
            int island = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(arr[i][j]==1 && !visited[i][j]) {
                        island++;
                        dfs(i, j, arr, visited);
                    }
                }
            }
            sb.append(island).append("\n");

        }
        System.out.println(sb);
    }
    public static void dfs(int r, int c, int[][] arr, boolean[][] visited) {
        visited[r][c] = true;

        for(int d=0; d<8; d++) {
            int newR = r+dr[d];
            int newC = c+dc[d];
            if(newR<0 || newR >= h || newC<0 || newC >= w || visited[newR][newC]) {
                continue;
            }
            if(arr[newR][newC] == 1) {
                dfs(newR, newC, arr, visited);
            }
        }
    }
}
