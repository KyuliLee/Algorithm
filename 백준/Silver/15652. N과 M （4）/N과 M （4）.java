import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] arr;
	private static StringBuilder sb = new StringBuilder("");
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// M개를 골라야 하니까 숫자 M개를 저장해놓을 크기가 M인 배열 선언
		arr = new int[M];
	
		func(N, M, 1, 0);
		System.out.println(sb);
		
	}
	public static void func(int N, int M, int forStart, int depth) {
		if(depth==M) {
			for(int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 숫자를 선택할 때 forStart부터 선택하게 하고 매개변수로 값을 넘겨줄 때 이 값을 변화시켜줌
		for(int i=forStart; i<=N; i++) {
			// arr 배열의 depth 번째 방에 숫자 i를 넣는다
			arr[depth] = i;
			// arr의 다음 칸에 들어갈 수 있는 숫자는 현재 선택한 숫자(i)부터 가능하므로 다음 dfs에서 for문을 현재 i부터 시작하면 된다 
			func(N, M, i, depth+1);
		}
	}
}