import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N==K || N*2==K) {
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[200002];
        visited[N] = true;
        Queue<int[]> q = new ArrayDeque<>(); // 0번 요소는 위치, 1번 요소는 걸린 시간
        q.offer(new int[]{N, 0});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == K) {
                System.out.println(curr[1]);
                return;
            }
            int next = 2*curr[0];
            if(next <= 200000 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[] {next, curr[1]}); // 2*X위치를 넣어줌
            }

            next = curr[0]-1;
            if(next >= 0 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[] {next, curr[1]+1});
            }

            next = curr[0]+1;
            if(next <= 200000 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[] {next, curr[1]+1});
            }
        }
    }
}
