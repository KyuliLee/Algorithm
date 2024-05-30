package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1427_소트인사이드 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		int[] arr= new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str.substring(i, i+1));
		}
		
		for(int i=0; i<N; i++) {
			int max = i;
			for(int j=i+1; j<N; j++) {
				if(arr[max] < arr[j]) max = j;
			}
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
		}
		for(int i=0; i<N; i++) {
			System.out.print(arr[i]);
		}
	}

}
