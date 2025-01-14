import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int L; // 상자 길이
    static int N; // 공 개수
    static int T; // 시간
    static int[] S; // i번째 공의 위치
    static char[] C; // i번째 공의 방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken())+1; // 상자 길이
        N = Integer.parseInt(st.nextToken()); // 공 개수
        T = Integer.parseInt(st.nextToken()); // 시간
        S = new int[N];
        C = new char[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken()); // i번째 공의 위치
            C[i] = st.nextToken().charAt(0); // i번째 공의 방향
        }
        // T만큼 돌면서 매 초마다 공의 위치, 방향 갱신, 충돌 횟수 카운트
        int cnt = 0;
        for(int t=1; t<=T; t++) {
            // N개의 공을 움직임.
            for(int i=0; i<N; i++) {
                int currBallPos = S[i];
                if(C[i] == 'L') {
                    S[i]--;
                    if(S[i] == 0) {
                        C[i] = 'R';
                    }
                } else {
                    S[i]++;
                    if(S[i] == L-1) {
                        C[i] = 'L';
                    }
                }
            }
            // N개의 공들을 Map에 넣음 <위치, 공 인덱스>
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<N; i++) {
                // key가 이미 존재하면 충돌 카운트, 공 방향 반대로 바꿈
                int pos = S[i]; // i번째 공의 위치
                if(map.containsKey(pos)) {
                    cnt++;
                    if(C[i] == 'L') {
                        C[i] = 'R';
                        int ballToChangeDirection = map.get(pos);
                        C[ballToChangeDirection] = 'L';
                    } else {
                        C[i] = 'L';
                        int ballToChangeDirection = map.get(pos);
                        C[ballToChangeDirection] = 'R';
                    }
                } else {
                    map.put(pos, i);
                }
            }
        }
        System.out.println(cnt);
    }
}