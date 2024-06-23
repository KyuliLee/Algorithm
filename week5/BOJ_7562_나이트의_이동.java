package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의_이동 {

	private static BufferedReader br;
	private static StringTokenizer st;
	private static int k;
	private static int l;
	private static int cnt;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int nowX; // 현재 위치
	private static int nowY;
	private static int goalX; // 이동해야 하는 위치
	private static int goalY;
	// 이동은 1시 방향부터 시계방향으로
	private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; // row의 움직임. 위로 가면 -. 아래로 가면 +
	private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};// column의 움직임. 오른쪽으로 가면 +, 왼쪽으로 가면 -
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) { 
			init();
			bfs();
		}
		
	}
	
	static void init() throws IOException {
		l = Integer.parseInt(br.readLine());
		arr = new int[l][l];
		visited = new boolean[l][l];
		st = new StringTokenizer(br.readLine());
		nowX = Integer.parseInt(st.nextToken());
		nowY = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		goalX = Integer.parseInt(st.nextToken());
		goalY = Integer.parseInt(st.nextToken());
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{nowX, nowY});
		visited[nowX][nowY] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			
			if(x == goalX && y == goalY) {
				System.out.println(arr[x][y]);
				return;
			}
			
			for(int i=0; i<8; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if(newX >=0 && newX < l && newY >=0 && newY < l && !visited[newX][newY]) {
					queue.add(new int[]{newX, newY});
					visited[newX][newY] = true;
					arr[newX][newY] = arr[x][y]+1;
				}
			}
		}
		System.out.println(-1);
		
	}


}
