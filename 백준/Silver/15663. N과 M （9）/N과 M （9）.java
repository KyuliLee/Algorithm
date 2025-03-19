import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums, arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static Set<int[]> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		arr = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		// nums 배열의 각 칸에 있는 숫자를 또 선택하면 안 되므로 중복이 없고
		// 1 7, 7 1이 모두 가능하므로 순서가 있다 -> 순열
		
		// 앞의 0 : 이번에 뽑을 숫자는 nums 배열의 0번째 숫자부터 가능
		// 뒤의 0 : 이번에 뽑을 숫자는 arr 배열의 0번째 방에 들어갈 것이다
		permute(0);
		System.out.println(sb);
		

	}
	static void permute(int depth) {
		// 만약 이번에 뽑을 숫자가 arr 배열의 M번째 방에 들어갈 차례라면
		// 이미 M개의 숫자를 다 뽑았으므로 리턴
		if(depth == M) {
			for(int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
        int lastPicked = -1;  // 마지막으로 선택한 숫자를 기억
        for (int i = 0; i < N; i++) {
            // 이미 방문한 숫자거나 이전에 선택한 숫자와 같으면 넘어감
            if (visited[i] || nums[i] == lastPicked) {
            	continue;
            }

            arr[depth] = nums[i];
            visited[i] = true;
            lastPicked = nums[i];  // 중복 방지를 위해 현재 숫자를 저장

            permute(depth + 1);

            visited[i] = false;
            
		}
		
	}
}