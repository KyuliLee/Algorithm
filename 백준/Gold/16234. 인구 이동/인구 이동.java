import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 초기화 완료
        int days = 0; // 인구가 이동하는 일 수

        while(true) { // while문 맨 밑에서 days 1 증가
            boolean check = false;
            boolean[][] visited = new boolean[N][N]; // 하루마다 방문 배열 새로 생성
            // 모든 칸을 돈다. 한 칸에서 사방탐색하면서 국경 열 수 있는 곳 찾아서 bfs
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(!visited[r][c]) {
                        // 이번 덩어리의 나라 수. arr 전체 돌면서 2 이상인 경우가 있기만 하면 인구 교환 가능.
                        int chunksNum = bfs(visited, r, c);
                        if(chunksNum >= 2) {
                            check = true;
                        }
                    }
                }
            }
            // 모든 칸을 다 돌았는데 인구 교환 못 하면 종료
            if(!check) { break; }
            days++;
        }
        System.out.println(days);
    }

    static int bfs(boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>(); // 연합한 나라 위치 정보 저장
        q.offer(new int[] {r, c});
        list.add(new int[] {r, c});
        int totalPopulation = arr[r][c]; // 이번 덩어리의 총 인구 수
        int cnt = 1; // 이번 덩어리의 나라 수

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            for(int d=0; d<4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];
                if(isValid(nr, nc) && !visited[nr][nc] && canMove(currR, currC, nr, nc)) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                    list.add(new int[] {nr, nc});
                    totalPopulation += arr[nr][nc];
                    cnt++;
                }
            }
        }
        int newPopulation = totalPopulation / cnt;
        for(int[] country : list) {
            arr[country[0]][country[1]] = newPopulation;
        }
        return cnt;
    }
    // r, c, nr, nc가 칸을 벗어나지 않고, 방문하지 않았고, r, c와의 인구 수 차이가 L이상, R이하인지 확인
    static boolean canMove(int r1, int c1, int r2, int c2) {
        int diff = Math.abs(arr[r1][c1]-arr[r2][c2]);
        if(diff >=L && diff <= R) return true;
        return false;
    }
    static boolean isValid(int r, int c) {
        if (r<0 || r>=N || c<0 || c>=N) {
            return false;
        }
        return true;
    }
}