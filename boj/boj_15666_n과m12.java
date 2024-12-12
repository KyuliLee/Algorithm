package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_15666_n과m12 {
    static int N;
    static int M;
    static int[] nums;
    static int[] arr;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
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
        if(depth==M) {
            String str = "";
            for(int n : arr) {
                str += n;
                str += " ";
            }
            // set에 str이 없으면 추가하고 sb에 append
            if(!set.contains(str)) {
                set.add(str);
                sb.append(str).append("\n");
            }
            return;
        }

        for(int i=startIdx; i<N; i++) {
            arr[depth] = nums[i];
            dfs(i, depth+1);
        }
    }
}