import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int top, start, target, U, D;
    static int cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        top = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[top+1]; // 1층부터 top층까지 방문 처리

        int res = bfs(start);
        if(res == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(res);
        }
    }
    static int bfs(int start) {
        int[] move = {U, D*(-1)};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            if(curr[0] == target) {
                return curr[1];
            }
            for(int m=0; m<2; m++) {
                int newFloor = curr[0] + move[m];

                if(newFloor < 1 || newFloor > top) {
                    continue;
                }

                if(visited[newFloor]) {
                    continue;
                }

                visited[newFloor] = true;
                q.offer(new int[] {newFloor, curr[1]+1});
            }
        }
        return -1;
    }
}
