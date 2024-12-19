import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(); // 오름차순 정렬
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n>0) {
                plus.offer(n);
                continue;
            }
            if(n<0) {
                minus.offer(n);
                continue;
            }
            // n==0이고 plus, minus 둘 다 비어있을 때
            if(plus.isEmpty() && minus.isEmpty()) {
                sb.append("0").append("\n");
                continue;
            }
            // n==0이고 minus에만 값이 있을 때
            if(plus.isEmpty() && !minus.isEmpty()) {
                sb.append(minus.poll()).append("\n");
                continue;
            }
            // n==0이고 plus에만 값이 있을 때
            if(!plus.isEmpty() && minus.isEmpty()) {
                sb.append(plus.poll()).append("\n");
                continue;
            }
            // n==0이고 둘 다 값이 있을 때 : peek으로 절댓값 비교
            int p = plus.peek();
            int m = minus.peek()*-1;
            if(p<m) {
                sb.append(plus.poll()).append("\n");
            } else if(p>m) {
                sb.append(minus.poll()).append("\n");
            } else {
                sb.append(minus.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
