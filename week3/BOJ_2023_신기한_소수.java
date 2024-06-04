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
		// 반복 조건에 i*i<=n, i<=n/2 둘 다 가능. 그러나 i*i<=n이 효율이 더 좋다.
		// 만약 n=29 라면 전자는 5까지만 확인하면 되지만 후자는 14까지 확인해야 한다.
		// 시간복잡도는 각각 O(루트n), O(n)이다. 
//		for(int i=2; i*i<=n; i++) { 
		for(int i=2; i<=n/2; i++) { 
			if(n%i == 0) return false;
		}
		return true;
	}


}
