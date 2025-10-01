import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];
        for(int i=0; i<N; i++) {
            ans[i] = -1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }

            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
