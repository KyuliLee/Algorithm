package week8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_1_2_3_더하기 {
	
	private static int cnt = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			cnt = 0;
			dfs(n, 0);
			System.out.println(cnt);
		}
	}
	
	static void dfs(int n, int sum) {
		// 종료 조건
		if(sum > n) return;
		
		
		if(sum == n) cnt++;
		
		dfs(n, sum+1);
		dfs(n, sum+2);
		dfs(n, sum+3);
		
	}
	
	

}
