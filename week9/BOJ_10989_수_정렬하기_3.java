import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989_수_정렬하기_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] nextArr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] cnt = new int[10001];
		for(int i=0; i<N; i++) {
			cnt[arr[i]]++;
		}
		for(int i=1; i<10001; i++) {
			cnt[i] = cnt[i-1] + cnt[i];
		}
		
		for(int i=N-1; i>=0; i--) {
			int value = arr[i];
			cnt[value]--;
			nextArr[cnt[value]] = value;
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<N; i++) {
			sb.append(nextArr[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}

