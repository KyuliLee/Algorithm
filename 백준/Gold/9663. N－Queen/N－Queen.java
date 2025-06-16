import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ans;
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; // 초기화 완료
        ans = 0;
        nQueen(0);
        System.out.println(ans);
    }
    public static void nQueen(int depth) {
        if(depth == N) {
            ans++;
            return;
        }

        for(int i=0; i<N; i++) {
            arr[depth] = i; // 인덱스는 열, 값은 행을 나타냄. arr[0] = 1 이면 1행 0열에 퀸을 놓는다
            if(possible(depth)) { // 그 위치에 놓는 게 가능한지 확인
                nQueen(depth+1);
            }
        }
    }
    public static boolean possible(int col) {
        for(int i=0; i<col; i++) {
            if(arr[col] == arr[i]) { // 다른 열, 같은 행에 퀸이 있는 경우
                return false;
            }
            if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) { // 열의 차이와 행의 차이가 같다 => 대각선에 퀸이 있는 경우
                return false;
            }
        }
        return true;
    }
}
