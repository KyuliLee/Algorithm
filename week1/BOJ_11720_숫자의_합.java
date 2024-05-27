package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720_숫자의_합 {

	public static void main(String[] args) throws IOException {
		
		
//		// 방법 1) BufferedReader, getBytes(). getBytes()가 의외로 종종 쓰이나보다. 기억해놓자.
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////		N = Integer.parseInt(br.readLine());
//		br.readLine(); // N은 받아도 쓸모가 없으므로 입력만 받는다.
//		
//		int sum = 0;
//
//		for(byte value : br.readLine().getBytes()){
//			sum += (value-'0');
//		}
//		System.out.println(sum);
//		
		// 방법 2) Scanner
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		String a = sc.next();
//		sc.close();
//		
//		int sum = 0;
//		for(int i=0; i<N; i++){
//			sum += (a.charAt(i)-'0');
//		}
//		System.out.println(sum);
//		
//		
		// 방법 3)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String str = br.readLine();
		char[] charArr = str.toCharArray();
		
		int sum=0;
		for(int i=0; i<charArr.length; i++){
			sum += charArr[i]-'0';
		}
		System.out.println(sum);
		
		
	}

}
