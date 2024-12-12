package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15655_n과m6 {
    static int N;
    static int M;
    static int[] nums;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 0);
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
        for(int i=startIdx; i<N; i++) {
            arr[depth] = nums[i];
            dfs(i+1, depth+1);
        }
    }
}
