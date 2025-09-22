import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] dpMax = new int[N+1][3];
        int[][] dpMin = new int[N+1][3];
        if(N == 1) {
            max = Math.max(arr[1][0], Math.max(arr[1][1], arr[1][2]));
            min = Math.min(arr[1][0], Math.min(arr[1][1], arr[1][2]));
            System.out.print(max + " " + min);
            return;
        }
        dpMax[1][0] = arr[1][0];
        dpMax[1][1] = arr[1][1];
        dpMax[1][2] = arr[1][2];
        dpMin[1][0] = arr[1][0];
        dpMin[1][1] = arr[1][1];
        dpMin[1][2] = arr[1][2];

        for(int i=2; i<=N; i++) {
            dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + arr[i][0];
            dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + arr[i][1];
            dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + arr[i][2];
        }
        for(int i=2; i<=N; i++) {
            dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + arr[i][0];
            dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + arr[i][1];
            dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + arr[i][2];
        }
        max = Math.max(dpMax[N][0], Math.max(dpMax[N][1], dpMax[N][2]));
        min = Math.min(dpMin[N][0], Math.min(dpMin[N][1], dpMin[N][2]));
        System.out.print(max + " " + min);



    }
}
