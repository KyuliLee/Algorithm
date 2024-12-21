import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] visited;
    static int N;
    static int M;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new int[N][M];
        for(int i=0; i<N; i++) {
            visited[i] = Arrays.copyOf(maps[i], M);
        }
        // 움직인 곳은 visited에서 0으로 만들기
        visited[0][0] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        while(!q.isEmpty()) {
            int[] currPos = q.poll();
            int r = currPos[0];
            int c = currPos[1];
            int dist = currPos[2];
            // 진영에 도착했으면 종료
            if(r==N-1 && c==M-1) {
                return dist;
            }
            
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(isValid(nr, nc) && visited[nr][nc]==1) {
                    visited[nr][nc] = 0;
                    q.offer(new int[] {nr, nc, dist+1});
                }
            }
        }
        // 큐 빌 때까지 상대 진영 도착 못 했으면 -1 리턴
        return -1;
    }
    static boolean isValid(int r, int c) {
        if(r<0 || r>=N || c<0 || c>=M) return false;
        return true;
    }
}