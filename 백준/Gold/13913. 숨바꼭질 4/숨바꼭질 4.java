import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N==K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }
        int[] visited = new int[200002]; // int형으로 하면 visited 배열에 그 위치까지 걸린 시간을 저장할 수 있다.
        int[] prev = new int[200002]; // 해당 위치의 정점에 도달하기 직전 정점의 값 저장
        visited[N] = 1;
        Queue<Integer> q = new ArrayDeque<>(); // 0번 요소는 위치, 1번 요소는 걸린 시간
        q.offer(N);

        while(!q.isEmpty()) {
            int curr = q.poll();
            int currTime = visited[curr];
            if(curr == K) {
                break;
            }

            for(int next : new int[] {curr-1, curr+1, curr*2}) {
                if(next<0 || next > 200000 || visited[next]>0) continue;
                visited[next] = currTime+1;
                prev[next] = curr;
                q.offer(next);
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=K; i!=N; i=prev[i]) {
            stack.push(i);
        }
        stack.push(N);
        StringBuilder sb = new StringBuilder();
        sb.append(visited[K]-1).append("\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
