import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] times, methods;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치
        times = new int[200001]; // 해당 위치까지 가는 최단 시간 저장
        methods = new int[200001]; // 해당 위치까지 갈 수 있는 경우의 수 저장

        if(N==K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        /*
        bfs로 최단 시간 찾기
         */
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        times[N] = 1; // 0으로 해놓으면 방문하지 않은 지점과 구분이 안 가기 때문에 일단 1로 시작하고 나중에 1을 빼줌
        methods[N] = 1; // 시작 위치로 가는 방법이 1개로 시작.
        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int i=0; i<3; i++) {
                int next = 0;
                if(i==0) next = curr+1;
                else if(i==1) next = curr-1;
                else if(i==2) next = curr*2;

                if(next<0 || next >= 200000) continue;

                if(times[next] == 0) { // 해당 위치를 아직 방문 안 했으면
                    times[next] = times[curr]+1; // 그 위치까지 가는 최단 시간 갱신
                    methods[next] += methods[curr]; // 그 위치까지 가는 방법은 지금 위치까지 가는 방법의 수와 같다
                    q.offer(next);
                } else if(times[next] == times[curr]+1) { // 해당 위치 방문했는데 그 때 최단시간이 지금 위치까지 가는 최단시간+1과 같으면
                    methods[next] += methods[curr]; // 해당 위치까지 가는 다른 방법이 있는거니까 방법만 더해줌
                }
            }
        }

        System.out.println(times[K]-1);
        System.out.println(methods[K]);

    }


}
