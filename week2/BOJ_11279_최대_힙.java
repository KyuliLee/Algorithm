package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_최대_힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqRvs = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now != 0) {
				pqRvs.add(now);
			} else if(pqRvs.isEmpty()) {
				sb.append(0).append('\n');
			} else if(!pqRvs.isEmpty()) {
				sb.append(pqRvs.remove()).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}
