package week5;
import java.io.*;
import java.util.*;

public class BOJ_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[100001]; // 해당 위치까지 몇 초만에 갔는지 저장하는 배열
		Arrays.fill(arr, -1);
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		arr[N] = 0;
		
		int subin = N;
		while(!queue.isEmpty()) {
			subin = queue.poll();
			if(subin == K) break;
			int newSubin1 = subin-1;
			int newSubin2 = subin+1;
			int newSubin3 = subin*2;
			
			if(newSubin1 >= 0 && newSubin1 <= 100000) {
				if(arr[newSubin1] == -1) {
					queue.add(newSubin1);
					arr[newSubin1] = arr[subin]+1;
				}
			}
			if(newSubin2 >= 0 && newSubin2 <= 100000) {
				if(arr[newSubin2] == -1) {
					queue.add(newSubin2);
					arr[newSubin2] = arr[subin]+1;
				}
			}
			if(newSubin3 >= 0 && newSubin3 <= 100000) {
				if(arr[newSubin3] == -1) {
					queue.add(newSubin3);
					arr[newSubin3] = arr[subin]+1;
				}
			}
		}
		
		System.out.println(arr[subin]);
		
		
	}

}
