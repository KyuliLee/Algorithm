import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int r;
    int c;
    int cnt;
    public Pos(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}
public class Main {
    static int M, N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            for(int j=1; j<=M; j++) {
                arr[i][j] = str.charAt(j-1)-'0';
                if(arr[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        } // 초기화 완료

        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(1, 1, 1));
        visited[1][1] = true;

        while(!q.isEmpty()) {
            Pos pos = q.poll();
            int currR = pos.r;
            int currC = pos.c;
            int currCnt = pos.cnt;

            if(currR == N && currC == M) {
                System.out.println(currCnt);
                return;
            }

            for(int d=0; d<4; d++) {
                int newR = currR+dr[d];
                int newC = currC+dc[d];
                if(!isValid(newR, newC) || visited[newR][newC]) {
                    continue;
                }
                q.offer(new Pos(newR, newC, currCnt+1));
                visited[newR][newC] = true;
            }

        }



    }
    static boolean isValid(int r, int c) {
        return r>0 && r<=N && c>0 && c<=M;
    }
}
