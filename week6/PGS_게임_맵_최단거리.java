package week6;
import java.util.*;

class PGS_게임_맵_최단거리 {
    private static int m;
    private static int n;
    private static boolean[][] visited;
    private static int cnt = 0;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) {
    	int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
            
        }
        int result = bfs(maps);
        System.out.println(result);
    }
    
    private static int bfs(int[][] maps) {
        cnt++;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	
        	for(int s=0; s<size; s++) {
        		int[] pos = queue.poll();
        		int currX = pos[0];
        		int currY = pos[1];
        		
        		if(currX == n-1 && currY == m-1) {
        			return cnt;
        		}
        		
        		for(int i=0; i<4; i++) {
        			int newX = currX + dx[i];
        			int newY = currY + dy[i];
        			if(newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
        				queue.offer(new int[] {newX, newY});
        				visited[newX][newY] = true;
        			}
        		}
//            cnt++; 
        		// cnt를 여기서 키우면 큐에서 노드를 하나 꺼낼 때마다 cnt 값이 증가.
        		// cnt는 bfs에서 현재 레벨의 탐색이 끝날 때마다 증가해야 한다.
        		// 그래서 큐의 사이즈를 활용해 현재 레벨의 노드들을 탐색한 뒤에 cnt를 증가시켜야 한다.
        	}
        	cnt++;
        }
        return -1;
    }
}