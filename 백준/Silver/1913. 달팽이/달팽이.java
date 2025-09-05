import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {1, 0, -1, 0}; // 순서 : 아래, 오른쪽, 위쪽, 왼쪽
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int ansR = -1;
        int ansC = -1;
        int[][] arr = new int[N][N];

        int i=0;

        while(true) {
            int k = N-2*i;
            if(k <= 1) break;
            int r = i;
            int c = i;
            int num = k*k;

            for(int d=0; d<4; d++) {
                for(int j=1; j<k; j++) {
                    if(num == target) {
                        ansR = r;
                        ansC = c;
                    }
                    arr[r][c] = num--;
                    r += dr[d];
                    c += dc[d];
                }
            }

            i++;
        }
        arr[i][i] = 1;
        if(target == 1) {
            ansR = i;
            ansC = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int ii=0; ii<N; ii++) {
            for(int j=0; j<N; j++) {
                sb.append(arr[ii][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(++ansR).append(" ").append(++ansC);
        System.out.println(sb);
    }
}
