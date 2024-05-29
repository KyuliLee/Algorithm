package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값_힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pqPlus = new PriorityQueue<>();
		PriorityQueue<Integer> pqMinus = new PriorityQueue<>(Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x > 0) {
				pqPlus.add(x);
			}
			if(x < 0) {
				pqMinus.add(x);
			} 
			if(x == 0) {
				// 양수와 음수 우선순위큐 모두가 비어있지 않을 때 - 두 우선순위큐의 head값의 절대값 비교
				if(!pqPlus.isEmpty() && !pqMinus.isEmpty()) {
					
					int headPlus = pqPlus.peek();
					int headMinus = Math.abs(pqMinus.peek());
					
					if(headPlus < headMinus) { // 양수 우선순위큐의 head값이 음수 우선순위큐의 head의 절댓값보다 작을 때
						sb.append(pqPlus.remove()).append('\n');
					} else if(headPlus > headMinus) { // 양수 우선순위큐의 head값이 음수 우선순위큐의 head의 절댓값보다 클 때
						sb.append(pqMinus.remove()).append('\n');
					} else { // 두 head의 절댓값이 같을 때
						sb.append(pqMinus.remove()).append('\n');
					}
				} // 양수 우선순위큐만 비어있지 않을 때
					else if(!pqPlus.isEmpty() && pqMinus.isEmpty()) {
						sb.append(pqPlus.remove()).append('\n');
				} // 음수 우선순위큐만 비어있지 않을 때
					else if(pqPlus.isEmpty() && !pqMinus.isEmpty()) {
						sb.append(pqMinus.remove()).append('\n');
				} // 양수, 음수 우선순위큐가 모두 비어있을 때
					else {
						sb.append(0).append('\n');
					}
			}
		}
		System.out.println(sb);
		
	}

}
