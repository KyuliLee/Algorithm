import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{') {
                System.out.println("i : " + i + ", ch : " + ch);
                stack.push(ch);
                continue;
            }
            if(stack.empty()) {
                return false;
            }
            char peekCh = stack.peek();
            if(ch==')' && peekCh == '(') {
                System.out.println("i : " + i + "ch : " + ch + ", peekCh : " + peekCh);
                stack.pop();
            } else if(ch==']' && peekCh == '[') {
                System.out.println("i : " + i + "ch : " + ch + ", peekCh : " + peekCh);
                stack.pop();
            } else if(ch=='}' && peekCh == '{') {
                System.out.println("i : " + i + "ch : " + ch + ", peekCh : " + peekCh);
                stack.pop();
            } else {
                System.out.println("i : " + i + ", ch : " + ch + ", peekCh : " + peekCh);
                return false;
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}