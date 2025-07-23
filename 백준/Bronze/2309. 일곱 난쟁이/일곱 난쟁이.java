import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] nan9 = new int[9];
	private static boolean[] visited = new boolean[9];
	private static int[] nan7 = new int[7];
	private static boolean isFinished = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			nan9[i] = Integer.parseInt(br.readLine());
		}
		
		calc(0, 0);

	}
	
	public static void calc(int depth, int sum) {
		// 종료 조건 - 이미 출력했으면 종료
		if(isFinished) return;
		
		// 종료 조건
		if(depth == 7) {
			if(sum == 100) {
				Arrays.sort(nan7);
				StringBuilder sb = new StringBuilder("");
				for(int i=0; i<7; i++) {
					sb.append(nan7[i]).append("\n");
				}
				System.out.println(sb);
				isFinished = true;
			}
			return;
		}
		if(depth<7 && sum >= 100) return;
		
		// 재귀 조건
		for(int i=0; i<9; i++) {
			
			if(visited[i]) continue;
			
			visited[i] = true;
			nan7[depth] = nan9[i];
			calc(depth+1, sum+nan9[i]);
			
			visited[i] = false;
		}
	}
}