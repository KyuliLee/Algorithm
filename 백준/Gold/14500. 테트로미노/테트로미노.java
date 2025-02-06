import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = 0;
        // 1번 도형 그대로
        for(int r=0; r<N; r++) {
            for(int c=0; c<=M-4; c++) {
                sum = (arr[r][c]+arr[r][c+1]+arr[r][c+2]+arr[r][c+3]);
                max = Math.max(max, sum);
            }
        }
        // 1번 도형 90도 회전
        for(int r=0; r<=N-4; r++) {
            for(int c=0; c<M; c++) {
                sum = (arr[r][c]+arr[r+1][c]+arr[r+2][c]+arr[r+3][c]);
                max = Math.max(max, sum);
            }
        }
        // 2번 도형
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = (arr[r][c] + arr[r][c+1] + arr[r+1][c] + arr[r+1][c+1]);
                max = Math.max(max, sum);
            }
        }
        // 3번 도형 그대로
        for(int r=0; r<=N-3; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = arr[r][c] + arr[r+1][c] + arr[r+2][c] + arr[r+2][c+1];
                max = Math.max(max, sum);
            }
        }
        // 3번 도형 왼쪽으로 90도 회전
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-3; c++) {
                sum = arr[r][c+2] + arr[r+1][c] + arr[r+1][c+1] + arr[r+1][c+2];
                max = Math.max(max, sum);
            }
        }
        // 3번 도형 왼쪽으로 180도 회전
        for(int r=0; r<=N-3; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = arr[r][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r+2][c+1];
                max = Math.max(max, sum);
            }
        }
        // 3번 도형 왼쪽으로 270도 회전
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-3; c++) {
                sum = arr[r][c] + arr[r][c+1] + arr[r][c+2] + arr[r+1][c];
                max = Math.max(max, sum);
            }
        }
        // 3번 도형 좌우대칭
        for(int r=0; r<=N-3; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = arr[r+2][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r+2][c+1];
                max = Math.max(max, sum);
            }
        }
        // 3번 도형 좌우대칭 후 왼쪽으로 90도 회전
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-3; c++) {
                sum = arr[r][c] + arr[r][c+1] + arr[r][c+2] + arr[r+1][c+2];
                max = Math.max(max, sum);
            }
        }
        // 3번 도형 좌우대칭 후 왼쪽으로 180도 회전
        for(int r=0; r<=N-3; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = arr[r][c] + arr[r+1][c] + arr[r+2][c] + arr[r][c+1];
                max = Math.max(max, sum);
            }
        }
        // 3번 도형 좌우대칭 후 왼쪽으로 270도 회전
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-3; c++) {
                sum = arr[r][c] + arr[r+1][c] + arr[r+1][c+1] + arr[r+1][c+2];
                max = Math.max(max, sum);
            }
        }
        // 4번 도형 그대로
        for(int r=0; r<=N-3; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = arr[r][c] + arr[r+1][c] + arr[r+1][c+1] + arr[r+2][c+1];
                max = Math.max(max, sum);
            }
        }
        // 4번 도형 오른쪽으로 90도
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-3; c++) {
                sum = arr[r+1][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r][c+2];
                max = Math.max(max, sum);
            }
        }
        // 4번 도형 좌우대칭
        for(int r=0; r<=N-3; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = arr[r][c+1] + arr[r+1][c] + arr[r+1][c+1] + arr[r+2][c];
                max = Math.max(max, sum);
            }
        }
        // 4번 도형 좌우대칭 후 오른쪽으로 90도
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-3; c++) {
                sum = arr[r][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r+1][c+2];
                max = Math.max(max, sum);
            }
        }
        // 5번 도형 그대로
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-3; c++) {
                sum = arr[r][c] + arr[r][c+1] + arr[r][c+2] + arr[r+1][c+1];
                max = Math.max(max, sum);
            }
        }
        // 5번 도형 오른쪽으로 90도
        for(int r=0; r<=N-3; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = arr[r+1][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r+2][c+1];
                max = Math.max(max, sum);
            }
        }
        // 5번 도형 오른쪽으로 180도
        for(int r=0; r<=N-2; r++) {
            for(int c=0; c<=M-3; c++) {
                sum = arr[r+1][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r+1][c+2];
                max = Math.max(max, sum);
            }
        }
        // 5번 도형 오른쪽으로 270도
        for(int r=0; r<=N-3; r++) {
            for(int c=0; c<=M-2; c++) {
                sum = arr[r][c] + arr[r+1][c] + arr[r+2][c] + arr[r+1][c+1];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}