package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로_탐색 {
	private static int[] dx = {0, 1, 0, -1}; // 순서대로 오른쪽, 아래, 왼쪽, 위
	private static int[] dy = {1, 0, -1, 0};
	private static int[][] maze;
	private static boolean[][] visited;
	private static int N;
	private static int M;
	private static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String line = br.readLine();
			for(int j=1; j<=M; j++) {
				maze[i][j] = line.charAt(j-1)-'0';
			}
		}
		
		BFS(1,1);
		System.out.println(maze[N][M]);
		
	}
	
	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(nx >= 1 && nx <= N && ny >=1 && ny <= M) {
					if(visited[nx][ny] == false && maze[nx][ny] != 0) {
						maze[nx][ny] = maze[node.x][node.y] + 1;
						visited[nx][ny] = true;
						queue.offer(new Node(nx, ny));
					}
				}
			}
			
		}
	}

}
