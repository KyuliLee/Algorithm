package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2468_안전_영역 {

	private static int N;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		
		// 비가 0부터 각 지점의 높이의 최댓값-1 만큼 내린 경우까지만 조사하면 된다.
		// 지역을 초기화하면서 높이의 최댓값을 구하자
		
		int height_max = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > height_max)
					height_max = arr[i][j];
			}
		}
		
		// 비가 rain만큼 왔을 때 높이가 rain 이하인 지점을 visited 배열에서 모두 true로 만든다.
		// 배열을 모두 돌면서 false인 지점을 찾으면 cnt++, dfs를 실행
		// dfs가 끝났을 때 safeArea 배열에 저장하고
		// safeArea 배열을 정렬(오름차순)해서 마지막 방의 값 출력
		
		int[] safeArea = new int[height_max];
		for(int rain=0; rain<height_max; rain++) {
			visited = new boolean[N][N]; // visited 배열 초기화
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] <= rain) 
						visited[i][j] = true;
				}
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			safeArea[rain] = cnt;
		}
		Arrays.sort(safeArea);
		Arrays.sort(safeArea, Collections.reverseOrder());
		
		
		System.out.println(safeArea[height_max-1]);
		
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(newX >= 0 && newX < N && newY >= 0 && newY < N) {
				if(!visited[newX][newY]) {
					dfs(newX, newY);
				}
			}
		}
	}

}
