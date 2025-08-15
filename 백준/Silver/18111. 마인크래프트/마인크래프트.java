import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B;
    static int[][] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
                if (arr[i][j] < minHeight) {
                    minHeight = arr[i][j];
                }
            }
        } // 초기화 완료

        /*
        블록 제거 2초, 블록 놓기 1초 걸림
        시간 최소, 높이 최대
         */

        int ansTime = Integer.MAX_VALUE;
        int ansHeight = -1;
        // 높이 최소부터 최대까지 층을 하나씩 만들어본다
        for(int h=minHeight; h<=maxHeight; h++) {
            int block = B;
            int time = 0;

            int needBlock = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    // 만들려는 층보다 높으면 블록 제거
                    if(arr[i][j] > h) {
                        time += 2*(arr[i][j]-h);
                        block += (arr[i][j]-h);
                    } else if(arr[i][j] < h) { // 만들려는 층보다 낮으면 블록 놓기
                        time += (h-arr[i][j]);
                        block -= (h-arr[i][j]);
                    }
                }
            }
            // 블록이 음수가 되면 안 되므로 이 층은 넘어감
            if(block < 0) {
                continue;
            }

            if(ansTime > time) {
                ansTime = time;
                ansHeight = h;
            } else if(ansTime == time) {
                if(ansHeight < h) {
                    ansHeight = h;
                }
            }
        }
        System.out.println(ansTime + " " + ansHeight);

    }
}