package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2750_수_정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N; i++) {
			int a = 0;
			while(a<N-1) {
				int b = a+1;
				if(arr[a] > arr[b]) {
					int temp = arr[a];
					arr[a] = arr[b];
					arr[b] = temp;
				}
				a++;
			}
		}
        for(int i=0; i<N; i++) {
            System.out.println(arr[i]);
        }
	}

}