package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1012_유기농_배추 {
	
	private static int T;
	private static int M; // 가로
	private static int N; // 세로
	private static int K;
	private static int cnt;
	private static int[][] arr;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][] visited;
	private static BufferedReader br;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
			init(); // 배추밭 초기화
			solution(); // 풀이
			System.out.print(cnt);
		}
	}
	
	static void init() throws IOException {
		cnt = 0;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		arr = new int[N][M]; // 세로가 N, 가로가 M이니까 [N][M] 으로 선언
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine()); // 입력값 순서는 x, y.
			int X = Integer.parseInt(st.nextToken()); 
			int Y = Integer.parseInt(st.nextToken());
			arr[Y][X] = 1; // 배추가 있는 곳의 위치는 [Y][X]
		}
	}
	
	static void solution() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
			}
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(newX >= 0 && newX < N && newY >= 0 && newY < M) {
				if(!visited[newX][newY] && arr[newX][newY] == 1) {
					dfs(newX, newY);
				}
			}
		}
	}
}
