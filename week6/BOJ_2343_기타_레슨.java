package week6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타_레슨 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		int mid = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			start = Math.max(start, arr[i]);
			end += arr[i];
		}
		
		while(start <= end) {
			mid = (start + end) / 2;
			if(resize(arr, N, M, mid)) {
				end = mid - 1; // 가능한 경우, 블루레이 사이즈를 줄여봄
			} else {
				start = mid + 1; // 불가능한 경우, 블루레이 사이즈를 키워봄
			}
		}
		
		System.out.println(start);
		
	}
	
	static boolean resize(int[] arr, int N, int M, int mid) {
		int cnt = 1; // 블루레이 개수
		int sum = 0; // 현재 블루레이에 담긴 강의 길이의 합
		
		for(int i=0; i<N; i++) {
			if(sum + arr[i] > mid) {
				cnt++; // 현재 블루레이에 담을 수 없으면 새로운 블루레이 사용
				sum = arr[i];
				if(cnt > M) {
					return false;
				}
				
			} else {
				sum += arr[i]; // 현재 블루레이에 계속 담음
			}
		}
		return true;
	}

}
