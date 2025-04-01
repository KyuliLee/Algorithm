import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        8*8 완탐을 하는데 하나의 8*8 마다 맨 왼쪽 위가 W인 경우, B인 경우 확인
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int min = 987654321;
        // 왼쪽 위 시작점이 [r][c]
        for(int r=0; r+7<N; r++) {
            for(int c=0; c+7<M; c++) {
                // 시작점이 W, B일 때 다시 칠해야 하는 칸 수
                int cntW = 0;
                int cntB = 0;
                for(int i=r; i<r+8; i++) {
                    for(int j=c; j<c+8; j++) {
                        if(i%2==0) { // 짝수 행
                            if(j%2==0) { // 짝수 열
                                if(arr[i][j]=='B') {
                                    cntW++;
                                } else {
                                    cntB++;
                                }
                            } else { // 홀수 열
                                if(arr[i][j]=='W') {
                                    cntW++;
                                } else {
                                    cntB++;
                                }
                            }
                        } else { // 홀수 행
                            if(j%2==0) { // 짝수 열
                                if(arr[i][j]=='W') {
                                    cntW++;
                                } else {
                                    cntB++;
                                }
                            } else { // 홀수 열
                                if(arr[i][j]=='B') {
                                    cntW++;
                                } else {
                                    cntB++;
                                }
                            }
                        }
                    }
                }
                min = Math.min(min, Math.min(cntW, cntB));
            }
        }
        System.out.println(min);
    }
}