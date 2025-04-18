import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c=='+' || c=='-' || c=='*') {
                ops.add(c);
            } else {
                nums.add(c-'0');
            }
        }
        dfs(nums.get(0), 0);
        System.out.println(max);

    }
    static void dfs(int result, int opIdx) {
        // 종료 조건
        if(opIdx >= ops.size()) {
            max = Math.max(max, result);
            return;
        }
        // 재귀
        // 괄호 없는 경우 : 현재까지의 값(result)와 다음 숫자 연산
        int num1 = cal(ops.get(opIdx), result, nums.get(opIdx+1));
        dfs(num1, opIdx+1);

        // 괄호 있는 경우 : 현재 값 다음 두 개의 숫자에 괄호를 친 값을 연산 후 현재 값과 연산
        if(opIdx+1 < ops.size()) {
            int num2 = cal(ops.get(opIdx+1), nums.get(opIdx+1), nums.get(opIdx+2));
            int num3 = cal(ops.get(opIdx), result, num2);
            dfs(num3, opIdx+2);
        }

    }
    static int cal(char op, int n1, int n2) {
        int res = 0;
        switch(op) {
            case('+'): {
                res = n1 + n2;
                break;
            }
            case('-'): {
                res = n1-n2;
                break;
            }
            case('*'): {
                res = n1*n2;
            }
        }
        return res;
    }
}
