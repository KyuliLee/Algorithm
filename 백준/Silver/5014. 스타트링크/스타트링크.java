import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        // F층 건물, G층에 스타트링크, S층에 강호. 강호는 S->G로 이동
        // U버튼은 위로 U층, D버튼은 아래로 D층을 이동
        // 강호가 G층에 도착하기 위해 버튼을 적어도 몇 번 눌러야 하는가?

        /*
        크기가 F+1인 일차원 배열을 선언. 1~F번 방까지 사용한다. i번 방의 값은 그 층에 가기 위해서 필요한 최소한의 버튼 누름 수.
        S층부터 시작하므로 arr[S] = 0이다.
        if(dp[S]+1 < dp[S+U]) {
            dp[S+U] = dp[S]+1;
        }
        if(dp[S]+1 < dp[S-D]) {
            dp[S-D] = dp[S]+1;
        }
        이렇게 하면 S+U가 S가 되고, S-D를 S로 바꿔서 매번 계산해야 하는데 최소한의 버튼 누름 수를 찾기 위해
        dp보다 bfs로 visited를 사용하는 게 더 적절해보임.
         */

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {S, 0}); // 큐에 층과 횟수 저장
        boolean[] visited = new boolean[F+1];
        visited[S] = true;
        boolean canUseElevator = false;
        int number = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == G) {
                number = curr[1];
                canUseElevator = true;
                break;
            }

            if(curr[0]+U <= F && !visited[curr[0]+U]) {
                visited[curr[0]+U] = true;
                q.offer(new int[] {curr[0]+U, curr[1]+1});
            }
            if(curr[0]-D > 0 && !visited[curr[0]-D]) {
                visited[curr[0]-D] = true;
                q.offer(new int[] {curr[0]-D, curr[1]+1});
            }
        }

        if(canUseElevator) {
            System.out.println(number);
        } else {
            System.out.println("use the stairs");
        }
    }
}







