import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12891_DNA_비밀번호 {
	static int[] min = new int[4]; // A, C, G, T 개수의 최솟값을 저장할 배열
	static int[] curr = new int[4]; // 현재 부분문자열에서 A, C, G, T의 개수를 저장할 배열
	
	static int check = 0; // A, C, G, T 중 몇 개의 조건을 충족했는지 저장하는 변수.
	static int cnt = 0; // 현재 문자열에 대해 check가 4가 될 경우에 ++

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Math.abs(Integer.parseInt(st.nextToken()));
		int P = Math.abs(Integer.parseInt(st.nextToken()));
		
		String dna = br.readLine();
		char[] dnaArr = dna.toCharArray();

		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++){
			min[i] = Integer.parseInt(st.nextToken());
			if(min[i] == 0) {
				check++;
			}
		}
		
		for(int i=0; i<P; i++) {
			Add(dnaArr[i]);
		}
		
		if(check == 4) {
			cnt++;
		}
		
		for(int j=P; j<S; j++) {
			int i = j-P;
			Add(dnaArr[j]);
			Remove(dnaArr[i]);
			if(check==4) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	private static void Add(char c){
		switch(c){
		case 'A':
			curr[0]++;
			if(curr[0] == min[0]){
				check++;
			}
			break;
		case 'C':
			curr[1]++;
			if(curr[1] == min[1]){
				check++;
			}
			break;
		case 'G':
			curr[2]++;
			if(curr[2] == min[2]){
				check++;
			}
			break;
		case 'T':
			curr[3]++;
			if(curr[3] == min[3]){
				check++;
			}
			break;
			
		}
	}
	
	private static void Remove(char c){
		switch(c){
		case 'A':
			if(curr[0] == min[0]){
				check--;
			}
			curr[0]--;
			break;
		case 'C':
			if(curr[1] == min[1]){
				check--;
			}
			curr[1]--;
			break;
		case 'G':
			if(curr[2] == min[2]){
				check--;
			}
			curr[2]--;
			break;
		case 'T':
			if(curr[3] == min[3]){
				check--;
			}
			curr[3]--;
			break;
		}
	}

}