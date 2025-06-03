import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int T;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        // [2]는 시간
        // [3]은 0이면 그람을 만나지 못한 경우, 1이면 그람을 만난 경우
        q.offer(new int[] {0, 0, 0, 0});

        boolean flag = false;
        int result = 0;
        // [][][0] : 아직 그람을 안 만난 경우, [][][1] : 그람 만난 경우 방문 처리
        // 그람을 안 만났을 때 이미 방문했지만 그람을 만난 뒤에 방문해야 더 빨리 가는 경로가 있을 수 있음
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            int time = curr[2];
            int canBreak = curr[3];

            if(time > T) {
                break;
            }

            if(currR == N-1 && currC == M-1) {
                flag = true;
                result = time;
                break;
            }

            for(int d = 0; d<4; d++) {
                int newR = currR+dr[d];
                int newC = currC+dc[d];

                if(!isValid(newR, newC)) {
                    continue;
                }
                // 그람을 만나지 않은 상태
                if(canBreak == 0) {
                    if(!visited[newR][newC][0]) {
                        if(arr[newR][newC] == 0) {
                            q.offer(new int[] {newR, newC, time+1, 0});
                            visited[newR][newC][0] = true;
                        } else if(arr[newR][newC] == 1) {
                            continue;
                        } else { // 이번에 그람을 만남
                            q.offer(new int[] {newR, newC, time+1, 1});
                            visited[newR][newC][1] = true;
                        }
                    }
                } else { // 그람을 만난 상태
                    if(!visited[newR][newC][1]) {
                        q.offer(new int[] {newR, newC, time+1, 1});
                        visited[newR][newC][1] = true;
                    }
                }
            }
        }
        if(flag && result <= T) {
            System.out.println(result);
        } else {
            System.out.println("Fail");
        }
    }
    public static boolean isValid(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}
