import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		if(N==1) {
			System.out.println(1);
			return;
		}
		if(N==2) {
			System.out.println(2);
			return;
		}
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i=3; i<=N; i++) {
			arr[i] = (arr[i-2]+arr[i-1])%10007;
		}
		System.out.println(arr[N]);
	}

}