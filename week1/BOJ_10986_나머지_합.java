package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986_나머지_합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long sum[] = new long[N];
//		long rem[] = new long[M]; // 나머지가 0, 1, 2, ..., M-1 인 경우가 몇 개나 있는지 저장하는 배열
		int rem[] = new int[M]; // 나머지가 0, 1, 2, ..., M-1 인 경우가 몇 개나 있는지 저장하는 배열
		long cnt = 0; // 나누어 떨어지는 구간의 개수 저장하는 변수
		
		st = new StringTokenizer(br.readLine());
		// sum 배열 초기화
		sum[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<N; i++){
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		// sum 배열 돌면서 나누어 떨어지는 구간의 개수를 카운트, rem 배열 초기화
		for(int i=0; i<N; i++){
			int remainder = (int) (sum[i] % M);
			if(remainder == 0) cnt++;
			rem[remainder]++;
		}
		
		// rem 배열 돌면서 xC2 수행
		// rem 배열의 각 요소는 나머지가 동일한 구간합의 개수이다.
		// 나머지가 같은 두 구간합 S[i], S[j] 가 있을 때 s[j]-s[i] 의 나머지 연산의 결과는 0
		for(int i=0; i<M; i++){
			if(rem[i]>1) {
				cnt += (long)rem[i]*(long)(rem[i]-1)/2;
			}
		}
		
		System.out.println(cnt);
		
		
		
		

		
	}

}
