import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		arr = new int[M];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		cal(0);
		System.out.println(sb);
		
	}
	
	static void cal(int depth) {
		if(depth == M) {
			for(int n : arr) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int prev = -1;
		
		for(int i=0; i<N; i++) {
			// 비내림차순 구현. n번째 숫자는 n-1번째 숫자보다 크거나 같아야 한다.
			if(depth == 0 || arr[depth-1] <= nums[i]) {
				// 이번 depth에서 선택할 숫자가 이전에 선택한 숫자와 같으면 넘어감
				// 같지 않은 경우 실행
				if(prev != nums[i]) {
					arr[depth] = nums[i];
					prev = nums[i];
					cal(depth+1);
				}
			} 
		}
	}
}