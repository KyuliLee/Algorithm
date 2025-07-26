import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        visited = new boolean[N][M];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currDist = curr[2];
            
            if(currR == N-1 && currC == M-1) {return currDist;} 
            for(int d=0; d<4; d++) {
                int newR = currR+dr[d];
                int newC = currC+dc[d];
                if(!isValid(N, M, newR, newC) || visited[newR][newC] ||
                   maps[newR][newC]==0) {
                    continue;
                }
                visited[newR][newC] = true;
                q.offer(new int[] {newR, newC, currDist+1});
            }
        }
        
        return -1;
    }
    boolean isValid(int N, int M, int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}