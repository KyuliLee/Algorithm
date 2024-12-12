package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15652_n과m4 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(1, 0);
        System.out.println(sb);

    }
    static void dfs(int startIdx, int depth) {
        // 종료 조건
        if(depth == M) {
            for(int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 재귀 부분
        for(int i=startIdx; i<=N; i++) {
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }
}
