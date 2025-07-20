import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        /* 풀이
        스택 사용
        여는 괄호 직후에 닫는 괄호가 오면 현재까지 스택에 있는 원소의 개수만큼 더함
        닫는 괄호 직후에 닫는 괄호가 오면 1만 더함
         */
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        char prev = '(';
        int cnt = 0;
        for(int i=1; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stack.push('(');
                prev = '(';
            } else {
                if(prev == '(') {
                    stack.pop();
                    cnt += stack.size();
                } else {
                    cnt++;
                    stack.pop();
                }
                prev = ')';
            }
        }
        System.out.println(cnt);
    }
}