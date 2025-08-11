import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
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
        return this.len - e.len; // 거리 짧은 순으로 정렬 == 오름차순 정렬
    }
}
public class Main {
    static int N, M;
    static int[][] arr, map;
    static int islandNum = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
//    static boolean[][] visited;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        map = new int[N][M];
//        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
        다리 : 바다와 인접, 길이가 최소 2 이상, 가로 일직선 또는 세로 일직선.
        다리 길이 최솟값 구하기
        1이 땅, 0이 바다
         */

        numbering();

        // 섬을 만나면 다리 만들기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] > 0) {
                    makeBridge(i, j, map[i][j]);
                }
            }
        }

        parents = new int[islandNum+1];
        for(int i=1; i<=islandNum; i++) {
            parents[i] = i;
        }

        int ans = shortestPath();
        System.out.println(ans);

    }

    static int shortestPath() {
        int sum = 0;
        int size = pq.size();
        for(int i=0; i<size; i++) {
            Edge edge = pq.poll();
            int x = edge.from;
            int y = edge.to;
            if(find(x) != find(y)) {
                sum += edge.len;
                union(x, y);
            }
        }
        int rx = parents[1];
        for(int i=2; i<=islandNum; i++) {
            if(rx != find(parents[i])) {
                return -1;
            }
        }
        return sum;
    }

    static int find(int x) {
        if(parents[x] == x)  return x;
        int root = find(parents[x]);
        return root;
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    static void makeBridge(int r, int c, int currIsland) {
        // 사방으로 다리놓기
        for(int d=0; d<4; d++) {
            int newR = r;
            int newC = c;
            int bridgeLen = 0;
            while(true) {
                newR += dr[d];
                newC += dc[d];
                // 이 방향이 더 이상 유효하지 않거나 동일한 섬으로 가는 방향이면 넘어감
                if(!isValid(newR, newC)) { break; }
                if(map[newR][newC] == currIsland) { break; }
                if(map[newR][newC] == 0) {
                    bridgeLen++;
                    continue;
                }
//                거리가 2 이상인 다른 섬 만나면 pq에 넣고 이 방향 종료
                if(bridgeLen >= 2) {
                    pq.offer(new Edge(currIsland, map[newR][newC], bridgeLen));
                }
                break;

            }
        }

    }

    static void numbering() {
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j]) { continue; }
                if(arr[i][j] == 1) {

                    map[i][j] = ++islandNum;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int d=0; d<4; d++) {
                            int newR = curr[0]+dr[d];
                            int newC = curr[1]+dc[d];

                            if(newR<0 || newR >=N || newC<0 || newC>=M) { continue; }
                            if(visited[newR][newC] || arr[newR][newC]==0) { continue; }
                            visited[newR][newC] = true;
                            map[newR][newC] = islandNum;
                            q.offer(new int[] {newR, newC});
                        }
                    }

                }
            }
        }
    }
    static boolean isValid(int r, int c) {
        if(r<0 || r>=N || c<0 || c>=M) {
            return false;
        }
        return true;
    }
}
