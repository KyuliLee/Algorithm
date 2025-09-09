import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>(); // ( 용 스택
        while(!str.equals(".")) {
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(') {
                    stack.push('(');
                } else if(c == ')') {
                    if(stack.isEmpty()) {
                        stack.push(')');
                        break;
                    } else {
                        if(stack.peek() == '(') {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                } else if(c == '[') {
                    stack.push('[');
                } else if(c == ']') {
                    if(stack.isEmpty()) {
                        stack.push(']');
                        break;
                    } else {
                        if(stack.peek() == '[') {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                }
            }
            if(stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

            stack.clear();
            str = br.readLine();
        }
        System.out.println(sb);
    }
}
