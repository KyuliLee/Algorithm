package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간_합_구하기_5 {
	private static int N;
	private static int M;
	private static int[][] arr;
	private static int[][] sumArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		sumArr = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<N+1; i++){
			sumArr[i][1] = sumArr[i-1][1] + arr[i][1];
			sumArr[1][i] = sumArr[1][i-1] + arr[1][i];
		}
		
		for(int i=2; i<N+1; i++){
			for(int j=2; j<N+1; j++){
				sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + arr[i][j];
			}
		}
		
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int result = sumArr[x2][y2]-sumArr[x2][y1-1]-sumArr[x1-1][y2]+sumArr[x1-1][y1-1];
			System.out.println(result);
			

		}
		
	}

}
