import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] papers = {0, 5, 5, 5, 5, 5};
    static int min = Integer.MAX_VALUE;
    static int num1 = 0;
    static int[][] arr = new int[10][10];
    static boolean[][] visited = new boolean[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean allZero = true;
        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    allZero = false;
                }
            }
        }
        if(allZero) {
            System.out.println(0);
            return;
        }
        func(0, 0, 0);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
    static void func(int r, int c, int cnt) {
        if(r>=9 && r>9) {
            min = Math.min(min, cnt);
            return;
        }
        if(cnt >= min) {
            return;
        }
        if(c>9) {
            func(r+1, 0, cnt);
            return;
        }
        if(arr[r][c] == 0) {
            func(r, c+1, cnt);
            return;
        }
        if(visited[r][c]) {
            func(r, c+1, cnt);
            return;
        }
        for(int i=1; i<=5; i++) {
            if(papers[i] > 0 && isSquareCovered(r, c, i)) {
                papers[i]--;
                makeSquareVisited(r, c, i);
                func(r, c+1, cnt+1);
                makeSquareUnvisited(r, c, i);
                papers[i]++;
            }
        }
    }
    static void makeSquareVisited(int r, int c, int n) {
        for(int i=r; i<r+n; i++) {
            for (int j = c; j < c + n; j++) {
                visited[i][j] = true;
            }
        }
    }
    static void makeSquareUnvisited(int r, int c, int n) {
        for(int i=r; i<r+n; i++) {
            for (int j = c; j < c + n; j++) {
                visited[i][j] = false;
            }
        }
    }
    static boolean isSquareCovered(int r, int c, int n) {
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(!isValid(i, j)) {
                    return false;
                }
                if(arr[i][j] == 0) {
                    return false;
                }
                if(visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isValid(int r, int c) {
        return r>=0 && r<10 && c>=0 && c<10;
    }
}
