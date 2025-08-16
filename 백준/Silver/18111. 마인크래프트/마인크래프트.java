import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int minHeight = 257;
        int maxHeight = -1;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
                if(arr[i][j] < minHeight) {
                    minHeight = arr[i][j];
                }
            }
        }
        /*
        블록 제거 2초, 블록 놓기 1초 소요
         */
        int time = Integer.MAX_VALUE;
        int height = Integer.MIN_VALUE;
        for(int h=minHeight; h<=maxHeight; h++) { // 땅 높이를 h로 만들기
            int tempTime = 0;
            int tempB = B;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] > h) { // 땅 높이가 h보다 높으면 제거
                        tempTime += (2 * (arr[i][j]-h));
                        tempB += (arr[i][j] - h);
                    } else if(arr[i][j] < h) { // 땅 높이가 h보다 낮으면 블록 놓기
                        tempTime += (h-arr[i][j]);
                        tempB -= (h-arr[i][j]);
                    }
                }
            }
            if(tempB >= 0) {
                if(tempTime < time) {
                    time = tempTime;
                    height = h;
                } else if(tempTime == time) {
                    if(height < h) {
                        height = h;
                    }
                }
            }
        }
        System.out.println(time + " " + height);


    }
}
