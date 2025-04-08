import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int max;
	static int areaNum;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // arr 배열 초기화 완료
		
		max = 0;
		
		for(int i=0; i<=100; i++) {
			// i만큼의 비가 올 때마다 visited 배열을 새로 만든다
			visited = new boolean[N][N];
			
			// arr를 돌면서 높이가 i보다 큰 영역의 개수를 구함
			areaNum = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					
					if(arr[r][c] > i && !visited[r][c]) {
						// i보다 큰 칸을 아직 방문하지 않았다면 영역 크기 1 증가
						areaNum++;
						// dfs를 돌면서 해당 영역을 모두 방문 처리
						dfs(i, r, c);
					}
				}
			}
			max = Math.max(max, areaNum);
		}
		System.out.println(max);
	}
	static void dfs(int i, int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int newR = r + dr[d];
			int newC = c + dc[d];
			
			if(newR<0 || newR>=N || newC<0 || newC>=N) {
				continue;
			}
			if(arr[r][c]>i && !visited[newR][newC]) {
				dfs(i, newR, newC);
			}
		}
	}
}