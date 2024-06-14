package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2667_단지번호붙이기 {
	
	private static int N;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int cnt = 0;
	private static int[] house;
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		house = new int[(N+1)*(N+1)];
		
		for(int i=1; i<N+1; i++) {
			String str = br.readLine();
			for(int j=1; j<N+1; j++) {
				arr[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
				
			}
		}
		System.out.println(cnt);
		// house 배열에는 cnt만큼만 집의 개수가 저장되어 있다.
		// house 배열을 cnt 크기만큼 자르고 오름차순 정렬해서 출력.
		house = Arrays.copyOf(house, cnt);
		Arrays.sort(house);
		for(int i=0; i<cnt; i++) {
			System.out.println(house[i]);
		}
		
		
	}
	
	static void dfs(int x, int y) {
		house[cnt]++;
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(newX >= 1 && newX <= N && newY >= 1 && newY <= N) {
				if(!visited[newX][newY] && arr[newX][newY] == 1) {
					dfs(newX, newY);
				}
			}
		}
	}
	

}
