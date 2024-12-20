import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int tc=0; tc<5; tc++) {
            char[][] room = new char[5][5];
            for(int i=0; i<5; i++) {
                room[i] = places[tc][i].toCharArray();
            } // room 초기화 완료
            
            boolean flag = true; // 거리두기 안 지켜지면 false로 변경
            for(int x=0; x<5; x++) {
                for(int y=0; y<5; y++) {
                    if(room[x][y] == 'O') continue;
                    if(room[x][y] == 'X') continue;
                    // P를 만나면 시작
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {x, y, 0});
                    
                    char[][] visited = new char[5][5];
                    
                    
                    while(!q.isEmpty()) {
                        int[] currPos = q.poll();
                        int r = currPos[0];
                        int c = currPos[1];
                        int dist = currPos[2];
                        
                        if(dist > 2) {continue;}
                        
                        if(dist > 0 && room[r][c] == 'P') {
                            flag = false;
                            break;
                        }
                        visited[r][c] = 'X';
                        
                        for(int d=0; d<4; d++) {
                            int nr = r+dr[d];
                            int nc = c+dc[d];
                            if(isValid(nr, nc) && visited[nr][nc] != 'X' && room[nr][nc] != 'X') {
                                q.offer(new int[] {nr, nc, dist+1});
                            }
                        }
                        if(!flag) break;
                    }
                    if(!flag) break;
                }
                if(!flag) break;
            }
            if(flag) {
                answer[tc] = 1;
            } else {
                answer[tc] = 0;
            }
            
        }
        return answer;
    }
    public boolean isValid(int r, int c) {
        if(r>=0 && r<5 && c>=0 && c<5) return true;
        return false;
    }
}