import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Network implements Comparable<Network>{
    int n;
    int elemNum;
    public Network(int n, int elemNum) {
        this.n = n;
        this.elemNum = elemNum;
    }
    @Override
    public int compareTo(Network net) {
        return net.elemNum - this.elemNum; // 내림차순 정렬
    }
}
public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int max = 0;
    static int elemNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        int[] cnt = new int[N+1];
        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            cnt[i] = bfs(i);
            max = Math.max(max, cnt[i]);
        }


        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(cnt[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

    }
    static int bfs(int start) {
        visited[start] = true;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int cnt = 1;

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next : graph[curr]) {
                if(visited[next]) continue;
                visited[next] = true;
                cnt++;
                q.offer(next);
            }
        }
        return cnt;
    }
}
