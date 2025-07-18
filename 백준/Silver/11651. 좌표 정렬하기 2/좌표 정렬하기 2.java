import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		// 증가하는 순서 => 오름차순
		PriorityQueue<Position> pq = new PriorityQueue<>((p1, p2) -> {
			if(p1.y != p2.y) {
				return p1.y - p2.y;
			}
			return p1.x - p2.x;
		});
		
		// pq에 좌표 넣기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new Position(x, y));
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			Position pos = pq.poll();
			sb.append(pos.x).append(" ").append(pos.y).append("\n");
		}
		System.out.println(sb);
	}

}

class Position {
	int x;
	int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}