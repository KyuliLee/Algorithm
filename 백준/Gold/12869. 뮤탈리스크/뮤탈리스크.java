import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // scv의 체력을 빼는 경우의 수
        int[][] a_ = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
        // 해당 정점까지 도달했을 때의 거리
        int[][][] dist = new int[61][61][61];
        /*
        scv의 체력 덩어리를 하나의 정점으로 본다.
        (12, 10, 4)는 시작 정점, bfs를 한 번 돌면서 6가지를 각각 뺀 게 다음 6개의 정점
        ex. 거리가 1인 정점들 : (3, 7, 3), (3, 9, 1), ...
        bfs 한 번 더 돌아서 거리가 2인 정점들은 각 정점에서 또 6가지 경우의 수를 각각 뺀 덩어리들.
        (0, 0, 0) 이 될 때의 거리를 찾자
         */
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {arr[0], arr[1], arr[2]});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int a = curr[0];
            int b = curr[1];
            int c = curr[2];

            if(a==0 && b==0 && c==0) break;

            for(int i=0; i<6; i++) {
                int na = a - a_[i][0];
                int nb = b - a_[i][1];
                int nc = c - a_[i][2];

                na = Math.max(0, na);
                nb = Math.max(0, nb);
                nc = Math.max(0, nc);

                if(dist[na][nb][nc] > 0) continue;
                dist[na][nb][nc] = dist[a][b][c]+1;
                q.offer(new int[] {na, nb, nc});
            }
        }
        System.out.println(dist[0][0][0]);
    }
}
