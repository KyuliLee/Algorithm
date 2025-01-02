import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 1920

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			int start = 0;
			int end = N-1;
			int target = arr[i];
			boolean flag = false;
			
			while(start <= end) {
				int mid = (start+end)/2;
				
				if(target < A[mid]) {
					end = mid-1;
				} else if(target > A[mid]) {
					start = mid+1;
				} else {
					flag = true;
					break;
				}
			}
			if(flag) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
		
	}

}