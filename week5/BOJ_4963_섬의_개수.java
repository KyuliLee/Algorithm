package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_섬의_개수 {

	private static BufferedReader br;
	private static StringTokenizer st;
	private static int w;
	private static int h;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; // 오른쪽부터 시계 방향
	private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		while(w != 0 && h != 0) {
			visited = new boolean[h][w];
			arr = new int[h][w];
			cnt = 0;
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<8; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(newX >= 0 && newX < h && newY >= 0 && newY < w) {
				  if(!visited[newX][newY] && arr[newX][newY] == 1) {
					  dfs(newX, newY);
				  }
			}
		}
	}

}
