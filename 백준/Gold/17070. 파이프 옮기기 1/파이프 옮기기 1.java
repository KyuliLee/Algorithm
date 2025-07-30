import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] ans;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};
    static int way = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
        빈 칸은 0, 벽은 1
         */
        ans[0][1] = 1;
        int currDirection = 0;
        dfs(0, 1, 0);
        System.out.println(way);
    }
    static void dfs(int r, int c, int d) {
        if(r == N-1 && c == N-1) {
            way++;
            return;
        }
        if(d == 0) {
            for(int i=0; i<=1; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if(newR<0 || newR>=N || newC<0 || newC>=N) { continue; }
                if(arr[newR][newC] == 1) { continue; }
                if(i==1 && (arr[newR-1][newC]==1 || arr[newR][newC-1]==1)) {continue;}

                dfs(newR, newC, i);
            }
        } else if(d == 1) {
            for(int i=0; i<=2; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if(newR<0 || newR>=N || newC<0 || newC>=N) { continue; }
                if(arr[newR][newC] == 1) { continue; }
                if(i==1 && (arr[newR-1][newC]==1 || arr[newR][newC-1]==1)) {continue;}

                dfs(newR, newC, i);
            }
        } else { // d == 2
            for(int i=1; i<=2; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if(newR<0 || newR>=N || newC<0 || newC>=N) { continue; }
                if(arr[newR][newC] == 1) { continue; }
                if(i==1 && (arr[newR-1][newC]==1 || arr[newR][newC-1]==1)) {continue;}

                dfs(newR, newC, i);
            }
        }
    }
}
