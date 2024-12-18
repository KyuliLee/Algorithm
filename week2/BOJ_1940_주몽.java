import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940_주몽 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		
		for(int i=1; i<N; i++){
			for(int j=i+1; j<N+1; j++){
				if((arr[i]+arr[j]) == M) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	
	}

}
