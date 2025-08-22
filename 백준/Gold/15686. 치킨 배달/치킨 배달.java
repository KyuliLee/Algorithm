import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] city;
	static int[] arr; // 없앨 치킨집 K개를 조합으로 저장할 배열
	static ArrayList<int[]> houses = new ArrayList<>();
	static ArrayList<int[]> stores = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 1) {
					houses.add(new int[] {i, j});
				} else if(city[i][j] == 2) {
					stores.add(new int[] {i, j});
				}
			}
		} // 초기화 완료
		// 치킨집 중 남아있을 M개 뽑기 -> 조합 사용.
		arr = new int[M]; // arr에는 없앨 치킨집의 인덱스를 저장
		comb(0, 0);
		
		System.out.println(min);
	}
	
	static void comb(int start, int depth) {
		// 종료 조건 : M개를 다 뽑았으면 치킨 거리를 계산, min과 비교하고 리턴
		if(depth == M) {
			min = Math.min(min, calCityDist());
			return;
		}
		// 반복 부분
		for(int i=start; i<stores.size(); i++) {
			arr[depth] = i;
			comb(i+1, depth+1);
		}
		
	}
	
	static int calCityDist() {
		int sum = 0;
		// houses를 돌면서 치킨 거리 계산
		for(int[] currHouse : houses) {
			int r1 = currHouse[0];
			int c1 = currHouse[1];
			int dist = Integer.MAX_VALUE;
			// 남아있을 M개의 치킨집의 인덱스가 저장되어 있는 arr를 돌면서 치킨 거리 최솟값 구하기
			for(int i=0; i<M; i++) {
				int[] currStore = stores.get(arr[i]);
				int r2 = currStore[0];
				int c2 = currStore[1];
				dist = Math.min(dist, calDist(r1, c1, r2, c2));
			}
			sum += dist;
		}
		return sum;
	}
	
	static int calDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}

}