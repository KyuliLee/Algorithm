import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder("<");
        int cnt = 0;
        while(q.size() != 1){
            cnt++;
            if(cnt == K) {
                sb.append(q.poll()).append(", ");
                cnt = 0;
            } else {
                q.offer(q.poll());
            }
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}