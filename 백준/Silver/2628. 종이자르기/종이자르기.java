import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> horizontal = new PriorityQueue<>();
        Queue<Integer> vertical = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==0) {
                horizontal.offer(b);
            } else {
                vertical.offer(b);
            }
        }
        horizontal.offer(N);
        vertical.offer(M);

        int prev = 0;
        int horizontalMax = -1;
        while(!horizontal.isEmpty()) {
            int num = horizontal.poll();
            horizontalMax = Math.max(horizontalMax, num-prev);
            prev = num;
        }

        prev = 0;
        int verticalMax = -1;
        while(!vertical.isEmpty()) {
            int num = vertical.poll();
            verticalMax = Math.max(verticalMax, num-prev);
            prev = num;
        }
        System.out.println(horizontalMax * verticalMax);

    }
}
