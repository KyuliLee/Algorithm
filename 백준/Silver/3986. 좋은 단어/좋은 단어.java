import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        /*
        좋은 단어 기준 : 같은 알파벳이 짝수 개, 여는 알파벳 뒤에 서로 다른 닫는 알파벳이 오면 안 된다.
        해당 알파벳이 stack에 없으면 넣음
        stack의 peek와 일치하면 stack에서 뺌, 만약 peek와 일치하지 않으면 좋은 단어가 아니다
        str을 다 돌았으면 stack이 비어있으면 좋은 단어.
         */
        Stack<Character> stack = new Stack<>();
        for(int n=0; n<N; n++) {
           String str = br.readLine();
           for(int i=0; i<str.length(); i++) {
               char c = str.charAt(i);
               if(stack.size() == 0) {
                   stack.push(c);
               } else {
                   if(stack.peek() == c) {
                       stack.pop();
                   } else {
                       stack.push(c);
                   }
               }
           }
           if(stack.isEmpty()) {
               cnt++;
           }
           stack.clear();
        }

        System.out.println(cnt);


    }
}
