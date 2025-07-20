import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                arrayDeque.offerLast(n);
            } else if(cmd.equals("pop")) {
                if(arrayDeque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(arrayDeque.pollFirst()).append("\n");
                }
            } else if(cmd.equals("size")) {
                sb.append(arrayDeque.size()).append("\n");
            } else if(cmd.equals("empty")) {
                if(arrayDeque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if(cmd.equals("front")) {
                if(arrayDeque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(arrayDeque.peekFirst()).append("\n");
                }
            } else {
                if(arrayDeque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(arrayDeque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}