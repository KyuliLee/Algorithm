import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        n = N;
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        int startNum = arr[0][0];
        // 1) N*N이 모두 같은 숫자인지 확인
        boolean isAllSame = true;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == startNum) continue;
                isAllSame = false;
                break;
            }
            if(!isAllSame) break;
        }
        if(isAllSame) {
            System.out.println(startNum);
            return;
        }

        // 2) 모두 같지 않다면 쪼개기
        dfs(0, 0, n/2);

        System.out.println(sb);

    }
    static void dfs(int startR, int startC, int n) {
        sb.append("(");

        // n이 1인 경우에는 그냥 하나씩 다 넣어!!
        if(n==1) {
            sb.append(arr[startR][startC]).append(arr[startR][startC+1]);
            sb.append(arr[startR+1][startC]).append(arr[startR+1][startC+1]);
            sb.append(")");
            return;
        }

        // 4개의 파트를 모두 확인. 왼쪽 위
        int startNum = arr[startR][startC];
        boolean isAllSame = true;
        for(int r=startR; r<startR+n; r++) {
            for(int c=startC; c<startC+n; c++) {
                if(arr[r][c] != startNum) {
                    isAllSame = false;
                    break;
                }
            }
            if(!isAllSame) break;
        }
        if(isAllSame) {
            sb.append(startNum);
        } else {
            dfs(startR, startC, n/2);
        }

        // 오른쪽 위
        startNum = arr[startR][startC+n];
        isAllSame = true;
        for(int r=startR; r<startR+n; r++) {
            for(int c=startC+n; c<startC+n+n; c++) {
                if(arr[r][c] != startNum) {
                    isAllSame = false;
                    break;
                }
            }
            if(!isAllSame) break;
        }
        if(isAllSame) {
            sb.append(startNum);
        } else {
            dfs(startR, startC+n, n/2);
        }

        // 왼쪽 아래
        startNum = arr[startR+n][startC];
        isAllSame = true;
        for(int r=startR+n; r<startR+n+n; r++) {
            for(int c=startC; c<startC+n; c++) {
                if(arr[r][c] != startNum) {
                    isAllSame = false;
                    break;
                }
            }
            if(!isAllSame) break;
        }
        if(isAllSame) {
            sb.append(startNum);
        } else {
            dfs(startR+n, startC, n/2);
        }

        // 오른쪽 아래
        startNum = arr[startR+n][startC+n];
        isAllSame = true;
        for(int r=startR+n; r<startR+n+n; r++) {
            for(int c=startC+n; c<startC+n+n; c++) {
                if(arr[r][c] != startNum) {
                    isAllSame = false;
                    break;
                }
            }
            if(!isAllSame) break;
        }
        if(isAllSame) {
            sb.append(startNum);
        } else {
            dfs(startR+n, startC+n, n/2);
        }

        // 4개 파트 모두 확인한 뒤에 괄호를 닫아줌
        sb.append(")");
    }
}
