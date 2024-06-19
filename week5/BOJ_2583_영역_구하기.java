package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583_영역_구하기 {
	
	private static int M;
	private static int N;
	private static int K;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int cnt = 0; // 영역의 개수를 저장
	private static int area = 0; // 영역의 넓이를 저장
	private static ArrayList<Integer> list = new ArrayList<>(); // 각 영역의 넓이를 저장할 리스트 선언
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int row=y1; row<y2; row++) {
				for(int col=x1; col<x2; col++) {
					arr[row][col] = 1;
				}
			}
		}
		
		for(int row=0; row<M; row++) {
			for(int col=0; col<N; col++) {
				if(!visited[row][col] && arr[row][col] == 0) {
					area = 1;
					cnt++;
					dfs(row, col);
					list.add(area);
				}
			}
		}
		
		System.out.println(cnt);
		// list를 오름차순 정렬하고 출력
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(newX >=0 && newX < M && newY >= 0 && newY < N) {
				if(!visited[newX][newY] && arr[newX][newY] == 0) {
					area++;
					dfs(newX, newY);
				}
			}
		}
	}
}
