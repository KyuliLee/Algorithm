import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int originN = Integer.parseInt(br.readLine());
        int N = originN;
        int target = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int r = 0, c = 0;
        int ansR = -1, ansC = -1;

        arr[N/2][N/2] = 1;
        if(target == 1) {
            ansR = N/2;
            ansC = N/2;
        }


        while(N > 1) {
            int num = N*N;
            for(int d=0; d<4; d++) {
                for(int i=1; i<N; i++) {
                    if(num == target) {
                        ansR = r;
                        ansC = c;
                    }
                    arr[r][c] = num--;
                    r += dr[d];
                    c += dc[d];
                }
            }
            r++;
            c++;
            N -= 2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<originN; i++) {
            for(int j=0; j<originN; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(++ansR).append(" ").append(++ansC);
        System.out.println(sb);
    }
}
