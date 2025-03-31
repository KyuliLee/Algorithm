import java.util.*;

class Pos {
    int r;
    int c;
    int foodAmount;
    
    public Pos(int r, int c, int foodAmount) {
        this.r = r;
        this.c = c;
        this.foodAmount = foodAmount;
    }
}

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] arr;
    static Queue<Pos> q = new LinkedList<>();
    static PriorityQueue<Intger> pq = new PriorityQueue<>(); // pq기본이 내림차순이니까 값 넣을 때 -1 곱해서 넣어야 함. 각 섬의 식량 숫자의 합 저장
    
    public int[] solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();
        visited = new boolean[N][M];
        arr = new int[N][M];
        boolean noIsland = true;
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
        return ans;
        
        // 섬 돌면서 bfs
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) {
                    continue;
                } else {
                    // 섬의 시작점 찾으면 bfs
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        q.offer(new Pos(i, j, arr[i][j]));
                        bfs();
                    }
                    // 해당 섬 다 돌면 pq에 섬의 식량에 -1 곱해서 넣음
                    
                }
            }
        }
        // 모든 곳 다 탐색하면 pq 크기의 int[] 선언해서 poll하면서 -1 곱해서 넣음
        
    }
    static void bfs() {
        int thisIslandFood = 0; // 으앙 이거를 bfs끝나면 pq에 넣어줘야함
        while(!pq.isEmpty()) {
            Pos curr = q.poll();
            
            for(int d=0; d<4; d++) {
                int newR = curr.r+dr[d];
                int newC = curr.c+dc[d];
                if(newR<0 || newR>=N || newC<0 || newC>=M || visited[newR][newC]) {
                    continue;
                }
                visited[newR][newC] = true;
                q.offer(new Pos(newR, newC, curr.foodAmount+arr[newR][newC]));
            }
        }
    }
}