import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            } else if(cmd.equals("top")) {
                if(idx<1) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(arr[idx-1]).append("\n");
                }
            } else if(cmd.equals("pop")) {
                if(idx<1) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(arr[--idx]).append("\n");
                }
            } else if(cmd.equals("size")) {
                sb.append(idx).append("\n");
            } else {
                if(idx<1) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}