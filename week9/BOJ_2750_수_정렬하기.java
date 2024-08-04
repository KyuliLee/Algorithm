import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 1. 버블 정렬
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		// 2. 선택 정렬
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		// 3. 카운팅 정렬 활용.. 으로도 해보기
		boolean[] arr = new boolean[2001];
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[n+1000] = true;
		}
		for(int i=0; i<2001; i++) {
			if(arr[i]){
				sb.append(i-1000).append("\n");
			}
		}
		

//		System.out.println(sb);
	}

}

