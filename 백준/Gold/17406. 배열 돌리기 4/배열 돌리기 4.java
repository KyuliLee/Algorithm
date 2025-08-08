import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static int[][] turnArr; // 1~K 의 회전 연산 저장
    static int[] ans; // 1~K의 순열 저장
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        turnArr = new int[K+1][3];
        ans = new int[K+1];
        visited = new boolean[K+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                turnArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
        dfs로 0~K-1의 순열로 회전해서 행렬의 값 구하기
        회전은 turn 함수, 이전 상태로 돌아가는건 rollback 함수 구현
         */
        dfs(1);
        System.out.println(min);
    }
    static void dfs(int depth) { // min은 회전 연산을 한 값
        if(depth == K+1) {
            int num = cal();
            min = Math.min(min, num);
            return;
        }
        for(int i=1; i<=K; i++) {
            if(visited[i]) { continue; }
            visited[i] = true;
            turn(i);
            ans[depth] = i;
            dfs(depth+1);
            rollback(i);
            visited[i] = false;
        }
    }
    static void turn(int n) {
        int middleR = turnArr[n][0];
        int middleC = turnArr[n][1];
        int S = turnArr[n][2];

        for(int s=S; s>0; s--) {
            int initR = middleR-s;
            int initC = middleC-s;
            int finalR = middleR+s;
            int finalC = middleC+s;

            int num2 = arr[initR][finalC];
            int num3 = arr[finalR][finalC];
            int num4 = arr[finalR][initC];

            // 맨 윗줄을 오른쪽으로 이동
            for(int c=finalC-1; c>=initC; c--) {
                arr[initR][c+1] = arr[initR][c];
            }
            // 맨 오른쪽 줄을 아래로 이동
            for(int r=finalR-1; r>=initR; r--) {
                arr[r+1][finalC] = arr[r][finalC];
            }
            // 맨 아래줄을 왼쪽으로 이동
            for(int c=initC+1; c<=finalC; c++) {
                arr[finalR][c-1] = arr[finalR][c];
            }
            // 맨 왼쪽 줄을 위로 이동
            for(int r=initR+1; r<=finalR; r++) {
                arr[r-1][initC] = arr[r][initC];
            }
            // 3개의 모서리들에 들어갈 값을 넣어줌
            arr[initR+1][finalC] = num2;
            arr[finalR][finalC-1] = num3;
            arr[finalR-1][initC] = num4;
        }
    }
    static void rollback(int n) {
        int middleR = turnArr[n][0];
        int middleC = turnArr[n][1];
        int S = turnArr[n][2];

        for(int s=S; s>0; s--) {
            int initR = middleR-s;
            int initC = middleC-s;
            int finalR = middleR+s;
            int finalC = middleC+s;

            int num1 = arr[initR][initC];
            int num3 = arr[finalR][finalC];
            int num4 = arr[finalR][initC];

            // 맨 윗줄을 왼쪽으로 이동
            for(int c=initC+1; c<=finalC; c++) {
                arr[initR][c-1] = arr[initR][c];
            }
            // 맨 왼쪽 줄을 아래로 이동
            for(int r=finalR-1; r>=initR; r--) {
                arr[r+1][initC] = arr[r][initC];
            }
            // 맨 아랫줄을 오른쪽으로 이동
            for(int c=finalC-1; c>=initC; c--) {
                arr[finalR][c+1] = arr[finalR][c];
            }
            // 맨 오른쪽 줄을 위로 이동
            for(int r=initR+1; r<=finalR; r++) {
                arr[r-1][finalC] = arr[r][finalC];
            }
            // 3개 모서리에 들어가야 하는 값 넣어줌
            arr[initR+1][initC] = num1;
            arr[finalR][initC+1] = num4;
            arr[finalR-1][finalC] = num3;
        }
    }
    static int cal() {
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            int sum = 0;
            for(int j=1; j<=M; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

}
