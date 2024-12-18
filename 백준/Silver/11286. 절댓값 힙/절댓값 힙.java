import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            int abs1 = Math.abs(n1);
            int abs2 = Math.abs(n2);
            if(abs1 == abs2) {
                return n1-n2;
            }
            return abs1 - abs2;
        });
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                if(pq.isEmpty()) {
                    sb.append("0").append("\n");
                    continue;
                }
                sb.append(pq.poll()).append("\n");
            } else {
                pq.offer(n);
            }

        }

        System.out.println(sb);
    }
}
