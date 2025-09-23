import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] arr;
    static int cnt = 0;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int mainR, mainC; // 도연 위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        // X는 벽. 못 감. I는 도연. P는 사람
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'I') {
                    mainR = i;
                    mainC = j;
                }
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {mainR, mainC});
        visited[mainR][mainC] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            for(int d=0; d<4; d++) {
                int nr = currR+dr[d];
                int nc = currC+dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                // 빈 공간이면 큐에 넣음, 벽이면 안 넣음, 사람이면 큐에 넣고 cnt 증가
                if(arr[nr][nc] == 'O') {
                    q.offer(new int[] {nr, nc});
                } else if(arr[nr][nc] == 'X') {
                    continue;
                } else if(arr[nr][nc] == 'P') {
                    q.offer(new int[] {nr, nc});
                    cnt++;
                }
            }
        }

        if(cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }



    }
}
