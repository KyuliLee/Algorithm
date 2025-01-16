import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int WHITE = 0;
    static final int BLUE = 1;
    static int white = 0;
    static int blue = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 초기화 완료
        int size = N;
        partition(0, 0, size);
        System.out.println(white);
        System.out.println(blue);
    }
    static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)) {
            if(arr[row][col] == WHITE) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        size /= 2;
        partition(row, col, size);
        partition(row, col+size, size);
        partition(row+size, col, size);
        partition(row+size, col+size, size);
    }

    static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col];
        for(int r=row; r<row+size; r++) {
            for(int c=col; c<col+size; c++) {
                if(arr[r][c] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}