import java.util.*;

class Pos {
    int r;
    int c;
    
    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] arr;
    static Queue<Pos> q = new LinkedList<>();
    static int thisIslandFood = 0;
    // pq기본이 내림차순이니까 값 넣을 때 -1 곱해서 넣어야 함. 각 섬의 식량 숫자의 합 저장
    static PriorityQueue<Integer> pq = new PriorityQueue<>(); 
    
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        arr = new int[N][M];
        boolean noIsland = true; // 모두 X인 경우 섬이 없다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                char c = maps[i].charAt(j);
                if(c=='X') {
                    visited[i][j] = true;
                    continue;
                } else {
                    noIsland = false;
                    arr[i][j] = c-'0';
                }
            }
        } // 초기화 완료
        // 섬 없으면 리턴
        if(noIsland) {
            int[] ans = new int[1];
            ans[0] = -1;
            return ans;
        }
        
        int cnt = 0;
        // 섬 돌면서 bfs
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j]) {
                    continue;
                } else {
                    // 섬의 시작점에서 bfs
                    visited[i][j] = true;
                    q.offer(new Pos(i, j));
                    cnt++;
                    bfs();
                    pq.offer(thisIslandFood);
                }
            }
        }
        // 모든 곳 다 탐색하면 pq 크기의 int[] 선언해서 poll하면서 넣음
        int size = pq.size();
        int[] ans = new int[size];
        for(int i=0; i<size; i++) {
            ans[i] = pq.poll();
        }
        
        return ans;
        
    }
    static void bfs() { 
        thisIslandFood = 0;
        while(!q.isEmpty()) {
            Pos curr = q.poll();
            thisIslandFood += arr[curr.r][curr.c];
            
            for(int d=0; d<4; d++) {
                int newR = curr.r+dr[d];
                int newC = curr.c+dc[d];
                if(newR<0 || newR>=N || newC<0 || newC>=M || visited[newR][newC]) {
                    continue;
                }
                visited[newR][newC] = true;
                q.offer(new Pos(newR, newC));
            }
        }
    }
}