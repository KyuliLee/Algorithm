package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1546_평균 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		long max = 0;
		long sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열에 점수를 넣기, 최댓값을 구하기, 점수의 총합을 구하기
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > max){
				max = arr[i];
			}
			sum += arr[i];
		}
		
		System.out.println(((sum*1.0/max)*100.0)/N);
	}

}
