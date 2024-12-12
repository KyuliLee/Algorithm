package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_15665_n과m11_방법1 {
    static int N;
    static int M;
    static int[] nums;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();

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

        dfs(0);
        System.out.println(sb);

    }
    static void dfs(int depth) {
        // 종료 조건
        if(depth == M) {
            StringBuilder tmpSb = new StringBuilder();
            for(int n : arr) {
                tmpSb.append(n).append(" ");
            }
            // set에 str 없으면 넣고 sb에 append
            // StringBuilder 객체가 set에 있는지 중복확인을 하면 잘 안 돼서
            // StringBuilder을 쓰려면 String으로 바꿔서 확인해야 한다.
            if(!set.contains(String.valueOf(tmpSb))) {
                set.add(String.valueOf(tmpSb));
                sb.append(tmpSb).append("\n");
            }
            return;
        }
        // 재귀 부분
        for(int i=0; i<N; i++) {
            arr[depth] = nums[i];
            dfs(depth+1);
        }
    }
}