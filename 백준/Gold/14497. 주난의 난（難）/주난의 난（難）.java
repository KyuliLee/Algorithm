import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N+1][M+1];
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j+1] = str.charAt(j);
            }
        }
        boolean[][] visited = new boolean[N+1][M+1];
        visited[r1][c1] = true;
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r1, c1});
        while(arr[r2][c2] != '0') {
            cnt++;
            Queue<int[]> temp = new ArrayDeque<>(); // 1 위치의 의미 : 이번 점프가 끝나면 다시 시작할 위치. temp에 넣을 것임

            while(!q.isEmpty()) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int d=0; d<4; d++) {
                    int nr = r+dr[d];
                    int nc = c+dc[d];
                    if(nr<1 || nr>N || nc<1 || nc>M || visited[nr][nc]) continue;
                    visited[nr][nc] = true;

                    if(arr[nr][nc] == '0') { // 0이면 계속해서 사방탐색할 것임. 큐에 넣음
                        q.offer(new int[] {nr, nc});
                    } else { // 1이면 0으로 바꾸고 temp에 넣음
                        temp.offer(new int[] {nr, nc});
                        arr[nr][nc] = '0';
                    }
                }
            }
            q = temp;
        }

        System.out.println(cnt);
    }
}
