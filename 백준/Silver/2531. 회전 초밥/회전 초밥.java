import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시 수. 접시는 0 ~ N-1번
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓수. 1~d까지 있다.
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] plates = new int[N]; // 접시에 초밥 종류 저장.
        for(int i=0; i<N; i++) { // 0번 접시, 1번 접시, ...
            plates[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        // 먹는 접시 번호
        // 7 8 9 10
        // 7 0 1 2
        // 쿠폰 번호는 처음부터 먹는다.
        // 크기가 k인 슬라이딩 윈도우를 돈다. 윈도우의 맨 앞을 삭제하고 맨 뒤를 추가하면서
        // 맨 앞 접시의 초밥 종류를 -- 하고 새로운 맨 뒤 접시의 초밥 종류를 ++ 한다.

        // 전체 초밥 가짓수에서 현재 윈도우에서 먹은 초밥 표시.
        int[] ate = new int[d+1];

        // 쿠폰 번호는 일단 먹는다.
        ate[c]++;

        // 초기 윈도우 설정
        int howManyKinds = 1;
        for(int i=0; i<k; i++) {
            int thisSushi = plates[i]; // thisSushi는 이번 접시의 초밥 종류
            if(ate[thisSushi] == 0) {
                howManyKinds++;
            }
            ate[thisSushi]++;
        }
        int lastPlate = k-1;
        // 윈도우 할 때마다 최댓값 확인
        max = Math.max(max, howManyKinds);

        // 슬라이딩~
        // 먹는 접시 번호
        // 7 8 9 10
        // 7 0 1 2
        for(int i=1; i<N; i++) {
            // 이번 윈도우 바로 앞의 것 제거
            int sushi = plates[i-1];
            ate[sushi]--;
            if(ate[sushi] == 0) {
                howManyKinds--;
            }
            // 맨 뒤의 것 추가
            lastPlate++;
            lastPlate %= N;
            int thisSushi = plates[lastPlate];
            if(ate[thisSushi] == 0) {
                howManyKinds++;
            }
            ate[thisSushi]++;

            max = Math.max(max, howManyKinds);
        }

        System.out.println(max);

    }
}

