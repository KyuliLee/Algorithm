import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static boolean[][] arr; // true면 막혀있음, false면 뚫려있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new boolean[H][W];
        st = new StringTokenizer(br.readLine());
        for(int col = 0; col <W; col++) {
            int n = Integer.parseInt(st.nextToken());
            for(int row = 0; row <n; row++) {
                arr[row][col] = true;
            }
        } // 초기화 완료

        int cnt = 0;
        for(int col = 0; col <W; col++) {
            for(int row = 0; row <H; row++) {
                if(arr[row][col]) { // 해당 지점이 벽이면 다음 벽이 있을 때까지 temp를 증가시키면서 오른쪽으로 감.
                    int k = col+1;
                    int temp = 0;

                    while(k<W && !arr[row][k]) {
                        temp++;
                        k++;
                    }
                    if(k < W) {
                        cnt += temp;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}
