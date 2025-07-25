import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr, map;
    static boolean[][] visited, visitedForMap;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int islandNum = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        visitedForMap = new boolean[N][N]; // map 만들기 위한 방문 배열
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    visited[i][j] = true;
                    visitedForMap[i][j] = true;
                }
            }
        } // 초기화 완료
        /*
        1) 섬 넘버링해서 map 배열에 저장
        2) 아무 섬에서 다른 섬으로 갈 때 번호가 다르면 최단거리 비교
         */
        map = new int[N][N]; // 섬 넘버링해서 저장할 배열
        makeMap();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 1 && isOutline(i, j)) {
                    visited = new boolean[N][N];
                    int res = bfs(i, j);
                    if(res == -1) {
                        continue;
                    }
                    min = Math.min(min, res);
                }
            }
        }
        System.out.println(min-1);
    }

    static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c, 0});
        int island = map[r][c];
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currDist = curr[2];
            int currIsland = map[currR][currC];
            if(currIsland > 0 && currIsland != map[r][c]) {
                return currDist;
            }

            for(int d=0; d<4; d++) {
                int newR = currR+dr[d];
                int newC = currC+dc[d];
                if(!isValid(newR, newC) || visited[newR][newC]) {
                    continue;
                }
                if(map[newR][newC] == island) {
                    continue;
                }
                visited[newR][newC] = true;
                q.offer(new int[] {newR, newC, currDist+1});
            }
        }
        return -1;
    }


    static void makeMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 1 && !visitedForMap[i][j]) {
                    islandNum++;
                    dfs(i, j);
                }
            }
        }
    }
    static void dfs(int r, int c) {
        // 섬 넘버링해서 map에 저장
        visitedForMap[r][c] = true;
        map[r][c] = islandNum;
        for(int d=0; d<4; d++) {
            int newR = r + dr[d];
            int newC = c + dc[d];
            if (!isValid(newR, newC) || visitedForMap[newR][newC]) {
                continue;
            }
            dfs(newR, newC);
        }
    }

    static boolean isValid(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
    static boolean isOutline(int r, int c) {
        for(int d=0; d<4; d++) {
            int newR = r + dr[d];
            int newC = c + dc[d];
            if (!isValid(newR, newC)) {
                continue;
            }
            if(map[newR][newC] == 0) {
                return true;
            }
        }
        return false;
    }
}
