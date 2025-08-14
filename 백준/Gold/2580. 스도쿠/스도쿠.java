import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[9][9];
    static int zero = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) zero++;
            }
        }
        /*
        81칸을 모두 돌면서 0인 칸에서 가능한 숫자를 넣고 dfs. 만약 가능한 숫자가 없다면 그 숫자를 다시 0으로 돌려놓고 리턴.
        모든 칸을 다 돌았으면 System.exit(0)으로 종료
         */

        dfs(0, 0);

    }
    static void dfs(int r, int c) {
        if(r == 9) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        // 이번 row의 모든 column이 다 채워졌다면 다음 row로 이동
        if(c == 9) {
            dfs(r+1, 0);
            return;
        }

        if(arr[r][c] == 0) {
            for(int i=1; i<=9; i++) {
                if(possible(r, c, i)) {
                    arr[r][c] = i;
                    dfs(r, c+1);
                }

            }
            arr[r][c] = 0;
            return;
        }

        // 0이 아니면 다음 칸으로 넘어감
        dfs(r, c+1);

    }
    static boolean possible(int r, int c, int n) {
        // 행에 중복된 숫자가 있는지 확인
        for(int j=0; j<9; j++) {
            if(arr[r][j] == n) {
                return false;
            }
        }

        // 열에 중복된 숫자가 있는지 확인
        for(int i=0; i<9; i++) {
            if(arr[i][c] == n) {
                return false;
            }
        }

        // 사각형에 중복된 숫자가 있는지 확인
        int row = r-(r%3);
        int col = c-(c%3);

        for(int i=row; i<row+3; i++) {
            for(int j=col; j<col+3; j++) {
                if(arr[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }
}
