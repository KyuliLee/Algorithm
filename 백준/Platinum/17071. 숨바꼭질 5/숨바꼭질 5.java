import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int maxPos = 500001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int turn = 1;
        boolean flag = false;
        if(N==K) {
            System.out.println(0);
            return;
        }
        int[][] visited = new int[2][maxPos];
        visited[0][N] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);

        /*
        1) 수빈이 먼저 t1번째 턴에 p 위치에 도착. 동생이 t2번째 턴에 p 위치에 도착
        t1, t2가 둘 다 홀수거나 둘 다 짝수이면 둘이 만날 수 있다. 수빈이가 t1+1번째 턴에 p+1로 갔다가 t1+2번째 턴에 p로 갔다가... 를 반복하고 있으면 되니까.
        2) 동생이 먼저 t번째 턴에 p 위치에 도착. 수빈도 동일한 턴에 p 위치에 도착해야 함
         */
        while(!q.isEmpty()) {
            // 동생 이동
            K += turn;
            if(K >= maxPos) {
                System.out.println(-1); // 최대 범위를 벗어나면 못 만나는 경우임
                return;
            }
            if(visited[turn%2][K] > 0) {
                flag = true;
                break;
            }
            // 동일한 턴에 수빈 이동
            int size = q.size();
            for(int i=0; i<size; i++) {
                int curr = q.poll();
                for(int next : new int[] {curr-1, curr+1, curr*2}) {
                    if(next<0 || next>=maxPos || visited[turn%2][next]>0) continue;
                    if(next == K) { // 이번 턴에서 수빈이 이동한 위치가 동생의 위치와 같다면 만났음
                        flag = true;
                        break;
                    }
                    visited[turn%2][next] = visited[(turn+1)%2][curr]+1;
                    q.offer(next);
                }
                if(flag) break;
            }
            if(flag) break;
            turn++;
        }
        if(flag) System.out.println(turn);
        else System.out.println(-1);

    }
}
