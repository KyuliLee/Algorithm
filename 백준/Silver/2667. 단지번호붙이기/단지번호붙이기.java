import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 사방탐색 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
				if (arr[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}

		// 단지 개수 저장
		int danji = 0;
		// 단지의 집의 개수를 저장할 리스트
		List<Integer> list = new ArrayList<>();

		// 모든 칸을 다 돌면서 1인 칸 찾는다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 아직 방문 안 했고 1인 칸 찾으면 그 칸부터 bfs로 사방탐색
				if (!visited[i][j] && arr[i][j] == 1) {
					// 단지 1 증가
					danji++;
					int houseNum = 0;

					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] currPos = q.poll();
						int r = currPos[0];
						int c = currPos[1];

						if (!visited[r][c] && arr[r][c] == 1) {
							houseNum++; // 해당 단지에서 집을 방문할 때마다 houseNum 증가
							visited[r][c] = true;
							for (int d = 0; d < 4; d++) {
								int newR = r + dr[d];
								int newC = c + dc[d];
								if (newR < 0 || newR >= N || newC < 0 || newC >= N) {
									continue;
								}
								if (!visited[newR][newC] && arr[newR][newC] == 1) {
									q.offer(new int[] { newR, newC });
								}
							}
						}
					}
					// 해당 단지의 탐색이 끝났으면 houseNum을 리스트에 추가
					list.add(houseNum);
				}
			}
		} // arr의 모든 칸 돌기 끝
		// list를 오름차순 정렬
		Collections.sort(list);

		StringBuilder sb = new StringBuilder("");
		sb.append(danji).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");

		}
		System.out.println(sb);
	}
}