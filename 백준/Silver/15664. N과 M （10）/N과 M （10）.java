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
	static Set<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
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
		
		permute(0);
		
		
		System.out.print(sb);
		
	}
	static void permute(int depth) {
		if(depth == M) {
			
			String str = Arrays.toString(arr);
			
			if(!set.contains(str)) {
				set.add(str);
				for(int n : arr) {
					sb.append(n).append(" ");
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				continue;
			}
			if(depth >= 1 && arr[depth-1] > nums[i]) {
				continue;
			}
			
			visited[i] = true;
			arr[depth] = nums[i];
			permute(depth+1);
			visited[i] = false;
		}
		
	}

}