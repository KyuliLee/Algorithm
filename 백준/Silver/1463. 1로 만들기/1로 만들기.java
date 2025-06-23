import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 
		 int[] arr = new int[N+1];
		 
		 if(N==1) {
			 System.out.println(0);
			 return;
		 }
		 if(N == 2 || N == 3) {
			 System.out.println(1);
			 return;
		 }
		 arr[1] = 0;
		 arr[2] = 1;
		 arr[3] = 1;
		 
		 for(int i=4; i<=N; i++) {
			 int a = arr[i-1];
			 int b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
			 if(i%2==0) {
				 b = arr[i/2];
			 }
			 if(i%3==0) {
				 c = arr[i/3];
			 }
			 
			 arr[i] = Math.min(a, Math.min(b, c)) + 1;
		 }
		 System.out.println(arr[N]);

	}

}