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
		
		// x가 작은 것부터, x가 같으면 y가 작은 것부터 정렬
		PriorityQueue<Position> pq = new PriorityQueue<>((p1, p2) -> {
			if(p1.x != p2.x)
				return p1.x - p2.x;
			return p1.y - p2.y;});

		for(int tc = 1; tc <= N; tc++) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.offer(new Position(x, y));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
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