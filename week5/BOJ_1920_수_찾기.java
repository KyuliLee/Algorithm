package week5;
import java.io.*;
import java.util.*;

public class BOJ_1920_수_찾기 {
	
	private static int M;
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			boolean find = false;
			
			int start = 0;
			int end = N-1;
			while(start <= end) {
				int mid = (start+end)/2;
				int value = arr[mid];
				if(target < value) {
					end = mid-1;
				} else if(target > value) {
					start = mid+1;
				} else { // target == value
					find = true;
					break;
				}
			}
			if(find) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			
		}
//		System.out.println(7/4); // 정수를 나눈 결과로 몫이 출력됨
		
	}

}
