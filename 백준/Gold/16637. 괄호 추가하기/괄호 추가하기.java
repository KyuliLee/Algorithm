import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] nums;
    static char[] ops;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[(N+1)/2];
        ops = new char[N/2];
        String str = br.readLine();
        for(int i=0; i<N; i++) {
            if(i%2==0) {
                nums[i/2] = str.charAt(i)-'0';
            } else {
                ops[i/2] = str.charAt(i);
            }
        }

        dfs(0, nums[0]);
        System.out.println(max);

    }
    static void dfs(int here, int num) {
        if(here == nums.length-1) {
            max = Math.max(max, num);
            return;
        }

        /*
        가능한 경우의 수는 2가지 밖에 없음. 괄호가 있냐 없냐
        3+8*7을 그대로 가는 경우 1개(괄호 없음), 3+(8*7) 인 경우 1개.
         */
        int res1 = cal(num, nums[here+1], ops[here]);
        dfs(here+1, res1);

        if(here+2 <= nums.length-1) {
            int temp = cal(nums[here+1], nums[here+2], ops[here+1]);
            int res2 = cal(num, temp, ops[here]);
            dfs(here+2, res2);
        }

    }
    static int cal(int n1, int n2, char op) {
        if(op == '+') return n1+n2;
        if(op == '-') return n1-n2;
        return n1*n2;
    }
}
