import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        while(!dq.isEmpty()) {
            int[] curr = dq.poll();
            if(curr[0] == N-1 && curr[1] == M-1) {
                System.out.println(curr[2]);
                return;
            }

            for(int d=0; d<4; d++) {
                int newR = curr[0] + dr[d];
                int newC = curr[1] + dc[d];
                if(newR<0 || newR>=N || newC<0 || newC>=M || visited[newR][newC]) continue;
                if(arr[newR][newC] == 0) continue;

                visited[newR][newC] = true;
                dq.offer(new int[] {newR, newC, curr[2]+1});
            }
        }
    }
}
