import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1]; // 각 노드에서 모든 노드를 방문하는 거리의 합의 최솟값 저장
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        } // 초기화 완료

        /*
        한 노드에서 다른 모든 노드에 방문하는 거리의 합이 최솟값인 노드 찾기.
        bfs 이용
         */
        Queue<Integer> q = new ArrayDeque<>();
        int minDist = Integer.MAX_VALUE;
        int answer = -1;
        for(int i=1; i<=N; i++) {
            // i번째 노드에서 다른 모든 노드에 가는 거리의 합 구하기
            q.clear();
            visited = new boolean[N+1];

            q.offer(i);
            visited[i] = true;
            int nodeDist = 0;
            int currDist = 0;

            while(!q.isEmpty()) {
                currDist++;
                int size = q.size();
                for(int s=0; s<size; s++) {
                    int curr = q.poll();
                    ArrayList<Integer> list = graph[curr];
                    for(int next : list) {
                        if(visited[next]) continue;
                        visited[next] = true;
                        nodeDist += currDist;
                        q.offer(next);
                    }
                }
            }
            if(minDist > nodeDist) {
                minDist = nodeDist;
                answer = i;
            }

        }

        System.out.println(answer);


    }
}
