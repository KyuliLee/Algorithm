package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<N+1; i++) {
			queue.add(i);
		}
		
		while(queue.size() != 1) {
			queue.remove();
			queue.add(queue.remove());
		}
		System.out.println(queue.remove());
		
	}

}
