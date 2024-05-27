package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2018_수들의_합_5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int s = 0;
		int e = 0;
		int cnt = 0;
		int sum = 0;
		
		while(e != N) {
			if(sum == N) {
				cnt++;
				e++;
				sum += e;
			} else if (sum < N) {
				e++;
				sum += e;
			} else {
				sum -= s;
				s++;
			}
		}
		cnt++;
		System.out.println(cnt);
	}

}
