package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int num = 1;
		
		for(int i=0; i<n; i++) {
			int now = Integer.parseInt(br.readLine());
			// 현재 입력받은 숫자가 오름차순으로 커지는 숫자보다 크다면 stack에 입력받은 숫자가 될 때까지 push
			// 현재 입력받은 숫자가 stack의 last in 숫자와 같다면 pop
			// 만약 두 경우에 해당하지 않으면 NO를 출력하고 리턴
			while(now >= num) {
				stack.push(num);
				num++;
				sb.append("+\n");
			} 
			if(now == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}

}
