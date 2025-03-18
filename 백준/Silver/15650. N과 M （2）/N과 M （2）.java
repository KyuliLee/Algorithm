import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] visited;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder("");
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// N개 중 M개를 선택함
		// 숫자가 1부터 N까지 있으므로 숫자를 선택했는지 여부를 나타내는 visited 배열의 크기는 N+1
		visited = new boolean[N+1];
		// 선택한 M개의 숫자를 저장하는 배열
		arr = new int[M];
		
		// 오름차순으로 정렬한 수열을 출력해야 함
		// 시작하는 숫자 매개변수를 넣는다. 1부터 시작
		// 현재 수열에 넣은 숫자 개수는 0개
		func(N, M, 1, 0);
		
		System.out.println(sb);
		
	}
	
	public static void func(int N, int M, int start, int depth) {
		// arr에 숫자가 M개가 다 찼으면 sb에 넣고 리턴
		if(depth == M) {
			for(int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 오름차순으로 정렬해야 한다
		// for문을 돌면서 숫자를 선택하는데, 선택하는 숫자는 매개변수로 받은 start부터이다.
		for(int i=start; i<=N; i++) {
			// 숫자 i를 이미 선택하지 않았다면
			if(!visited[i]) {
				// visited 배열에서 true로 바꿔주고
				visited[i] = true;
				// 수열을 나타내는 arr 배열의 depth번째 칸에 i를 넣는다
				arr[depth] = i;
				
				// 오름차순이므로 현재 선택한 숫자 i의 다음에 선택할 수 있는 숫자는 i보다 큰 숫자이다.
				// i
				func(N, M, i+1, depth+1);
			}
			visited[i] = false;
		}
	}

}