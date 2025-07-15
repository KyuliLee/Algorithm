import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] s = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			s[i] = Integer.parseInt(br.readLine());
		}
		
		int[] max = new int[N+1];
		
		max[1] = s[1];
		if(N==1) {
			System.out.println(max[1]);
			return;
		}
		max[2] = s[1]+s[2];
		if(N==2) {
			System.out.println(max[2]);
			return;
		}
		
		for(int i=3; i<=N; i++) {
			max[i] = Math.max(max[i-2], max[i-3]+s[i-1]) + s[i];
		}
		System.out.println(max[N]);
	}

}