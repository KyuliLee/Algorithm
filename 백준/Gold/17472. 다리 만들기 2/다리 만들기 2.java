import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int len;
    public Edge(int from, int to, int len) {
        this.from = from;
        this.to = to;
        this.len = len;
    }
    @Override
    public int compareTo(Edge e) {
        return this.len - e.len; // 거리를 기준으로 오름차순 정렬
    }
}
public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int islandNum;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numbering();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] > 0) {
                    makeBridge(i, j, arr[i][j]);
                }
            }
        }
        parents = new int[islandNum+1];
        for(int i=1; i<=islandNum; i++) {
            parents[i] = -1;
        }
        int ans = calShortestPath();
        System.out.println(ans);
    }
    static int calShortestPath() {
        int sum = 0;
        int edgeNum = 0; // 연결된 간선의 개수 세기. 트리의 특성에 따라 섬의 숫자(정점)-1이어야 함.

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.from;
            int v = edge.to;
            int len = edge.len;

            int ru = find(u);
            int rv = find(v);

            // 두 점의 루트가 같다면 이미 같은 그룹(최소신장트리)에 속해있으므로 넘어감
            if(ru == rv) continue;

            union(ru, rv);
            sum += len;
            edgeNum++;
        }

        if(edgeNum != islandNum-1) {
            return -1;
        }
        int root = find(1);
        for(int i=2; i<=islandNum; i++) {
            if(find(i) != root) {
                return -1;
            }
        }
        return sum;
    }
    static void union(int ru, int rv) {
        parents[rv] = ru;
    }
    static int find(int v) {
        if(parents[v] == -1) {
            return v;
        }
        return parents[v] = find(parents[v]);
    }
    // 해당 위치에서 4방향으로 다리 만들 수 있으면 pq에 넣음
    static void makeBridge(int r, int c, int currIsland) {
//        // from, to, len이 동일한 Edge를 pq에 또 넣지 않기 위해 방문 배열 사용
//        boolean[][] visited = new boolean[N][M];
//        visited[r][c] = true;

        for(int d=0; d<4; d++) {
            int newR = r;
            int newC = c;
            int len = 0;

            while(true) {
                newR += dr[d];
                newC += dc[d];

                // 유효하지 않거나, 이동 위치가 현재 섬 안이면 넘어감
                if(!isValid(newR, newC) || arr[newR][newC] == currIsland) break;

                // 바다이면 다리 길이 증가, 다른 섬이면 다리 길이가 2보다 작으면 다른 방향 탐색, 2 이상일 때 pq에 넣고 다른 방향 탐색
                if(arr[newR][newC] == 0) {
                    len++;
                } else {
                    if(len<2) {
                        break;
                    } else {
                        pq.offer(new Edge(currIsland, arr[newR][newC], len));
                        break;
                    }
                }
            }
        }
    }
    static void numbering() {
        islandNum = 0;
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) continue;
                if(visited[i][j]) continue;
                islandNum++;
                visited[i][j] = true;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] {i, j});
                while(!q.isEmpty()) {
                    int[] curr = q.poll();
                    arr[curr[0]][curr[1]] = islandNum;

                    for(int d=0; d<4; d++) {
                        int newR = curr[0]+dr[d];
                        int newC = curr[1]+dc[d];

                        if(!isValid(newR, newC) || visited[newR][newC]) continue;
                        if(arr[newR][newC] == 0)  continue;

                        visited[newR][newC] = true;
                        q.offer(new int[] {newR, newC});
                    }
                }
            }
        }
    }
    static boolean isValid(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}
