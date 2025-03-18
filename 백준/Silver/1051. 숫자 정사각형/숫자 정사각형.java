import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        } // 초기화 완료

        // [0][0]부터 시작
        // 정사각형을 찾는 문제이므로 행은 N/2까지, 열은 M/2까지의 점에서 시작하는 사각형을 찾는다.
        // 오른쪽, 아래 꼭짓점의 유효성 확인
        // 오른쪽, 아래, 오른쪽 아래 꼭짓점 순으로 값 확인
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M-1; j++) {
                int len = 0;

                while(true) {
                    len++;

                    int right = j+len;
                    int bottom = i+len;
                    if(right >= M || bottom >= N) {
                        break;
                    }

                    if(arr[i][right] != arr[i][j]) {
                        continue;
                    }
                    if(arr[bottom][j] != arr[i][j]) {
                        continue;
                    }
                    if(arr[bottom][right] != arr[i][j]) {
                        continue;
                    }
                    max = Math.max(max, (len+1)*(len+1));
                }
            }
        }
        System.out.println(max);
    }
}