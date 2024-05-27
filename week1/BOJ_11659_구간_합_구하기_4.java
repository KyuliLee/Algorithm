package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간_합_구하기_4 {
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] sumArr;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		arr[0] = 0;
		sumArr = new int[N+1];
		sumArr[0] = 0;
		

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			arr[i+1] = Integer.parseInt(st.nextToken());
			sumArr[i+1] = sumArr[i]+arr[i+1];
		}
		
		for(int j=0; j<M; j++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sum(a, b);
		}
	}
	private static void sum(int a, int b){
		int result = sumArr[b] - sumArr[a-1];
		System.out.println(result);
	}


}
