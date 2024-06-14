package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로_탐색 {
	
	private static int N;
	private static int M;
	private static int[][] maze;
	private static boolean[][] visited;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};

	private static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		// 2178 미로 탐색 다시 풀고 넘어가기
		// https://yab-lab.tistory.com/7
		
		// (1, 1) ~ (N, M) 위치로 갈 때 지나야 하는 칸 수의 최솟값 구하기 -> BFS
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 문제에서 요구하는 출발점이 (1,1) 이므로 N+1, M+1 크기의 matrix 생성
		maze = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		// 미로 초기화
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=M; j++) {
				// 숫자를 char형으로 나타낼 때는 ASCII CODE로 표현됨
				// 0은 48, 1은 49, ... 
				// 따라서 ASCII CODE 48인 char형 문자 '0' 을 빼면 0, 1, ... 의 숫자로 제대로 표현 가능
				maze[i][j] = str.charAt(j-1)-'0';
			}
		}
		
		// BFS를 이용해 최초로 도달했을 때 깊이를 출력
		BFS(1, 1);
		System.out.println(maze[N][M]);
	}
	
	static void BFS(int x, int y) {
		
		// 현재 위치를 큐에 넣는다.
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		// 현재 위치의 방문 여부를 true로 변경
		visited[x][y] = true;
		
		// 큐가 비어있지 않을 동안 반복.
		// BFS에서 현재 깊이에서 갈 수 있는 모든 노드를 탐색하는 과정. 
		// 큐에 들어있는 노드들이 현재 깊이에서 갈 수 있는 노드들이다. 큐에 들어있는 Node를 poll한다.
		// 현재 위치에서 오른쪽, 아래, 왼쪽, 위 칸 중 방문할 수 있는 칸에 현재 칸의 값에서 1을 더해서 저장
		// 방문 여부를 true로 바꾸고 큐에 넣는다
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int i=0; i<4; i++) {
				int newX = node.x + dx[i];
				int newY = node.y + dy[i];
				if(newX >= 1 && newX <= N && newY >= 1 && newY <= M) {
					if(!visited[newX][newY] && maze[newX][newY] != 0) {
						maze[newX][newY] = maze[node.x][node.y]+ 1; 
						visited[newX][newY] = true;
						queue.offer(new Node(newX, newY));
					}
				}
			}
		}
		
		
		
	}

}
