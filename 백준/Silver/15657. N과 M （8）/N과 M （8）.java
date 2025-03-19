import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums, arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		// 수열들은 사전 순으로 정렬되어야 하므로 nums 배열을 오름차순 정렬한다.
		Arrays.sort(nums);
		// 뽑은 M개의 숫자를 저장할 배열 arr
		arr = new int[M];
		
		// 이번에 뽑을 숫자는 nums배열의 0번째 방의 숫자부터 가능하고, arr 배열의 0번째 방에 들어갈 것이다.
		permute(0, 0);
		
		System.out.println(sb);

	}
	
	static void permute(int start, int depth) {
		// 종료 조건
		// 이번에 뽑을 숫자가 arr 배열의 M번 방에 들어갈 숫자라면 M개의 숫자를 이미 뽑았다는 뜻이므로 종료
		if(depth == M) {
			for(int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀 부분
		// nums를 돌면서 arr 배열의 depth번째 방에 들어갈 숫자 선택
		// 숫자는 nums 배열의 i번째 방의 숫자인데 i는 start 인덱스부터 가능하다
		for(int i=start; i<N; i++) {
			arr[depth] = nums[i];
			// arr에 다음 방(depth+1번 방)에 들어갈 숫자를 선택하자
			// 1 1, 7 7 처럼 같은 숫자를 중복해서 선택할 수 있으므로
			// 그 숫자는 nums 배열의 i번째 방의 숫자부터 가능하다.
			permute(i, depth+1);
		}
	}
}