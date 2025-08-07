import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, M, K;
    static char[][] arr;
    static String target;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int len;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            char[] chArr = str.toCharArray();
            arr[i] = chArr;
        }
        target = br.readLine();
        char start = target.charAt(0);
        len = target.length();
        dp = new int[N][M][len];
        for(int[][] arr : dp) {
            for(int[] arr2 : arr) {
                Arrays.fill(arr2, -1);
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == start) {
                    cnt += dfs(i, j, 0);
                }
            }
        }
        System.out.println(cnt);

    }
    static int dfs(int r, int c, int depth) {
        if(dp[r][c][depth] != -1) {
            return dp[r][c][depth];
        }
        if(depth == len-1) {
            return 1; // target이 다 만들어진 경우
        }

        int cnt = 0;
        for(int d=0; d<4; d++) {
            for(int k=1; k<=K; k++) {
                int newR = r + dr[d]*k;
                int newC = c + dc[d]*k;
                // 한 번 배열 바깥으로 나가면 k가 커져도 계속 나갈거니까 for문 중단
                if(newR<0 || newR >= N || newC<0 || newC >=M) {
                    break;
                }
                if(arr[newR][newC] == target.charAt(depth+1)) {
                    cnt += dfs(newR, newC, depth+1);
                }

            }
        }
        return dp[r][c][depth] = cnt;
    }

}
