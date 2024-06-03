package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023_신기한_소수 {
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		
	}
	
	static void DFS(int n, int jarisu) {
		if(jarisu == N) {
			System.out.println(n);
			return;
		}
		for(int i=1; i<=9; i++) {
			if(i%2==0) continue;
			if(checkPrime(10*n+i)) {
				DFS(10*n+i, jarisu+1);
			}
		}
	}
	
	static boolean checkPrime(int n) {
		// 1로 나누는 경우는 나머지가 항상 0이므로 제외
		// 2부터 2/n(버림) 인 숫자로 나눠서 나머지가 없으면 소수가 아니므로 false 리턴
		// cf) int형 홀수를 2로 나누면 소수점 이하를 버림한 정수가 저장됨
//		for(int i=2; i*i<=n; i++) { // 왜 i<=n/2 가 안 되지??
		for(int i=2; i*i<=n; i++) { // 왜 i<=n/2 가 안 되지??
			if(n%i == 0) return false;
		}
		return true;
	}


}
