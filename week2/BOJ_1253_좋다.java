import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++){
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		
		for(int m=0; m<N; m++) {
			int s = 0;
			int e = N-1;
			long k = arr[m];
//			System.out.println("k : " + k);
			while(s < e) {
				if(arr[s] + arr[e] > k) {
//					System.out.println("1번 s : " + s + ", e : " + e);
					e--;
				}
				else if(arr[s] + arr[e] < k) {
//					System.out.println("2번 s : " + s + ", e : " + e);
					s++;
				}
				else if(arr[s] + arr[e] == k){ // s나 e가 m과 일치하면 안 됨.
					// arr[s]가 0이고 e == m 인 경우, s == m 이고 arr[e]가 0인 경우는 더해서 자기 자신이 되지만 
					// 자기 자신을 연산하는 경우는 제외해야 한다.
//					System.out.println("일치 - s : " + s + ", e : " + e);
					if(s != m && e != m){
						cnt++;
						break;	
					} else if (s == m) { // 10 10 0 0 인 경우를 생각해보자
						s++;
					} else if(e == m) { // 0 0 10 10 인 경우를 생각해보자
						e--;
					}
				}
			}
		}
		System.out.println(cnt);
		
	}

}
