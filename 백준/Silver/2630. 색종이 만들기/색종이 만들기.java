import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int WHITE = 0;
    static final int BLUE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 초기화 완료

        int tmp = N;
        boolean[][] visited = new boolean[N][N];
        int wNum = 0;
        int bNum = 0;
        while(true) {
            // 길이가 tmp인 정사각형의 모든 칸이 색이 같으면 방문 체크
            // 모든 칸을 방문했으면 반복 종료
            // 모든 칸을 방문한 게 아니면 tmp를 반으로 줄임
            for(int startR=0; startR<N; startR+=tmp) {
                for(int startC=0; startC<N; startC+=tmp) {
                    // 해당 정사각형을 이미 방문했으면 넘어감
                    if(visited[startR][startC]) continue;
                    // flag가 true면 해당 정사각형을 방문 체크
                    // 하나라도 색이 다르면 false로 갱신
                    boolean flag = true;
                    int currColor = arr[startR][startC];
                    for(int r=startR; r<startR+tmp; r++) {
                        for(int c=startC; c<startC+tmp; c++) {
                            if(arr[r][c] == currColor) {
                                continue;
                            }
                            flag = false;
                            break;
                        }
                        if(!flag) {
                            break;
                        }
                    }
                    if(!flag) {
                        continue;
                    }
//                    System.out.print("tmp: " + tmp + ", startR : " + startR + ", startC : " + startC);
                    for(int r=startR; r<startR+tmp; r++) {
                        for(int c=startC; c<startC+tmp; c++) {
                            visited[r][c] = true;
                        }
                    }
                    if(currColor == WHITE) { wNum++; }
                    else { bNum++; }
//                    System.out.println(", wNum : " + wNum + ", bNum : " + bNum);
                }
            }
            tmp /= 2;
            if(tmp == 0) { break; }
        }
        System.out.println(wNum);
        System.out.println(bNum);
    }
}