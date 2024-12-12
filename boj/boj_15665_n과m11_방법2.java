package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15665_n과m11_방법2 {
    static int N;
    static int M;
    static int[] nums;
    static int[] arr;
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

        permute(0);
        System.out.println(sb);

    }

    static void permute(int depth) {
        if(depth==M) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i=0; i<N; i++) {
            if(prev != nums[i]) {
                arr[depth] = nums[i];
                prev = nums[i];
                permute(depth+1);
            }
        }
    }
}