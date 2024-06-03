package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1032_명령_프롬프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strArr = new String[N];
		
		for(int i=0; i<N; i++) {
			strArr[i] = br.readLine();
		}
		int len = strArr[0].length();
		char[] result = new char[len];
		
		for(int i=0; i<len; i++) {
			boolean flag = true;
			
			for(int j=0; j<N-1; j++) {
				if(strArr[j].charAt(i) != strArr[j+1].charAt(i)) {
					flag = false;
					break;
				}
			}
			if(!flag) {
				result[i] = '?';
			} else {
				result[i] = strArr[0].charAt(i);
			}
		}
		
		System.out.println(result);
		
		

		
	}

}
