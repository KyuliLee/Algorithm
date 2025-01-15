import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int RED = 0;
    private static int GREEN = 1;
    private static int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<N; i++) {
            cost[i][RED] += Math.min(cost[i-1][GREEN], cost[i-1][BLUE]);
            cost[i][GREEN] += Math.min(cost[i-1][RED], cost[i-1][BLUE]);
            cost[i][BLUE] += Math.min(cost[i-1][RED], cost[i-1][GREEN]);
        }
        int ans = Math.min(cost[N-1][BLUE], Math.min(cost[N-1][RED], cost[N-1][GREEN]));
        System.out.println(ans);
    }
}