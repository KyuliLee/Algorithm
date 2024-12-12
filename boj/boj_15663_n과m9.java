package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_15663_n과m9 {
    static int N;
    static int M;
    static int[] nums;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0);
        System.out.println(sb);


    }
    static void dfs(int depth) {
        // 종료 조건
        if(depth == M) {
            String str = "";
            for(int n : arr) {
                str += n;
                str += " ";
            }
            // 만약 set에 str이 없다면 넣고 sb에 append
            if(!set.contains(str)) {
                set.add(str);
                sb.append(str).append("\n");
            }
            return;
        }
        // 재귀 부분
        for(int i=0; i<N; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = nums[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }
}
