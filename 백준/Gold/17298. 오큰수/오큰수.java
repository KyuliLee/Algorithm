import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 오큰수 : 현재 인덱스의 숫자(Ai)보다 나중에 들어왔으면서 현재 인덱스의 숫자보다 큰 숫자
		// stack : 인덱스 저장
		// arr : 주어진 수열을 저장할 배열
		// result : 오큰수를 저장할 배열
		// stack에 0을 넣고 시작한다.
		//
		// stack이 비어있지 않고 stack의 top(=인덱스)의 숫자 < arr[i] 이면
		// arr[i]가 stack의 top(=인덱스)의 숫자의 오큰수가 되므로
		// result[stack.pop()] = arr[i] 로 result 배열의 stack의 top(인덱스) 위치에 오큰수를 저장한다.
		// 그 다음 stack의 top(=인덱스)의 숫자와 arr[i]를 또 비교
		// 만약 stack의 top(=인덱스)의 숫자 > arr[i] 이면 stack에 i를 저장한다.
		// 만약 stack이 비어있는 경우도 stack에 i를 저장한다.
		//
		// stack에 인덱스가 남아있다면 그 인덱스는 오큰수가 없다.
		// result 배열의 해당 인덱스에 -1 저장
		//
		// result 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for(int i=1; i<N; i++) {
			while(!stack.empty() && arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(result[i]).append(' ');
		}
		System.out.println(sb);
		
	}

}
