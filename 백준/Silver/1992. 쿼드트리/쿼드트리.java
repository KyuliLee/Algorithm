import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        recur(0, 0, N);

        System.out.println(sb);

    }
    static void recur(int startR, int startC, int n) {
        int startNum = arr[startR][startC];
        for(int r=startR; r<startR+n; r++) {
            for(int c=startC; c<startC+n; c++) {
                if(arr[r][c] != startNum) {
                    sb.append("(");
                    int half = n/2;
                    recur(startR, startC, half);
                    recur(startR, startC+half, half);
                    recur(startR+half, startC, half);
                    recur(startR+half, startC+half, half);
                    sb.append(")");

                    return;
                }
            }
        }
        sb.append(startNum);
    }
}
