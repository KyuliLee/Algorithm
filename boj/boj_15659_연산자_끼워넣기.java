package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15659_연산자_끼워넣기 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[] nums;
    static int[] ops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ops = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    // 현재까지 계산한 숫자를 num, 다음에 계산할 숫자의 인덱스를 idx라고 하자
    static void dfs(int num, int idx) {
        // 종료 조건
        if(idx == N) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        // 재귀 호출
        for(int i=0; i<4; i++) {
            // 연산자 개수가 1개 이상이면
            if(ops[i]>0) {
                ops[i]--;
                switch(i){
                    case 0 : dfs(num+nums[idx], idx+1); break;
                    case 1 : dfs(num-nums[idx], idx+1); break;
                    case 2 : dfs(num*nums[idx], idx+1); break;
                    case 3 : dfs(num/nums[idx], idx+1); break;
                }
                ops[i]++;
            }
        }
    }
}
