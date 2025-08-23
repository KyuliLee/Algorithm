import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][][] dist;
    static boolean canReach = false;
    static int minDist = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[2][N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        
        if(N==1 && M==1) {
            System.out.println(1);
            return;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int w = curr[0];
            int r = curr[1];
            int c = curr[2];

            for(int d=0; d<4; d++) {
                int newR = r + dr[d];
                int newC = c + dc[d];

                if(newR<0 || newR>=N || newC<0 || newC>=M) continue;

                if(w==0) { // 아직 벽 안 만났음.
                    if(arr[newR][newC] == 0) { // 다음 위치도 벽 아님
                        if(dist[0][newR][newC] == 0) { // 다음 위치가 아직 방문 안 했음(지금이 최단거리)
                            dist[0][newR][newC] = dist[0][r][c]+1;
                            q.offer(new int[] {0, newR, newC});
                        }
                    } else { // 다음 위치가 벽임
                        if(dist[1][newR][newC] == 0) { // 벽을 아직 방문 안 했음
                            dist[1][newR][newC] = dist[0][r][c]+1;
                            q.offer(new int[] {1, newR, newC});
                        }
                    }
                } else { // 이미 벽 한 번 부쉈음
                    if(arr[newR][newC] == 0) { // 다음 위치 벽 아님
                        if(dist[1][newR][newC] == 0) { // 다음 위치 아직 방문 안 했음(지금이 최단거리)
                            dist[1][newR][newC] = dist[1][r][c]+1;
                            q.offer(new int[] {1, newR, newC});
                        }
                    }
                }

                if(newR == N-1 && newC == M-1) {
                    minDist = Math.max(dist[0][N-1][M-1], dist[1][N-1][M-1])+1;
                    canReach = true;
                    break;
                }
            }
            if(canReach) break;
        }
        if(canReach) {
            System.out.println(minDist);
        } else {
            System.out.println(-1);
        }
    }
}
