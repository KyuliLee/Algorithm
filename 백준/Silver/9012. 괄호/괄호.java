import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int t=1; t<=T; t++) {
            String str = br.readLine();
            boolean flag = true;
            for(int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                if(ch == '(') {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()) {
                flag = false;
            }
            if(flag) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

            stack.clear();
        }
        System.out.println(sb);

    }
}
