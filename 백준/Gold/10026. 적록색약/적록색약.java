import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int r;
    int c;
    char color;
    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new char[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        } // 초기화 완료
        /*
        모든 좌표를 BFS로 사방탐색하면서 글자들의 영역 개수 찾기.
        [0][0]부터 시작해서 같은 색인 위치만 큐에 넣고 방문처리
        큐가 비워졌다면 R, C를 증가시키면서 방문 안 한 위치 찾아서 다시 큐에 넣기.
        R, C 증가 : N이 100 이하니까 걍 완탐 돌려
         */
        // 1. 적록색약이 아닌 사람
        visited = new boolean[N][N];
        int area = 0;
        Queue<Pos> q = new LinkedList<>();
        int r = 0;
        int c = 0;
        char color = arr[r][c];
        while(r != -1 && c != -1) {
            q.offer(new Pos(r, c));
            visited[r][c] = true;

            while(!q.isEmpty()) {
                Pos curr = q.poll();
                r = curr.r;
                c = curr.c;
                color = arr[r][c];

                for(int d=0; d<4; d++) {
                    int newR = r+dr[d];
                    int newC = c+dc[d];
                    if(!isValid(newR, newC) || visited[newR][newC]) {
                        continue;
                    }
                    // 같은 색의 구역이면 큐에 넣고 방문처리
                    if(arr[newR][newC] == color) {
                        q.offer(new Pos(newR, newC));
                        visited[newR][newC] = true;
                    }
                }
            }
            area++; // 큐에 넣었던 [r][c]의 색깔 구역에 해당함
            // r, c 증가시키면서 방문 안 한 위치 찾기
            int[] notVisited = findNotVisited();
            r = notVisited[0];
            c = notVisited[1];
        }
        System.out.print(area);
        System.out.print(" ");

        // 2. 적록색약인 사람
        visited = new boolean[N][N];
        area = 0;
        q = new LinkedList<>();
        r = 0;
        c = 0;
        color = arr[r][c];
        color = arr[r][c];
        while(r != -1 && c != -1) {
            q.offer(new Pos(r, c));
            visited[r][c] = true;

            while(!q.isEmpty()) {
                Pos curr = q.poll();
                r = curr.r;
                c = curr.c;
                color = arr[r][c];

                for(int d=0; d<4; d++) {
                    int newR = r+dr[d];
                    int newC = c+dc[d];
                    if(!isValid(newR, newC) || visited[newR][newC]) {
                        continue;
                    }
                    // G-R 색의 구역이면 큐에 넣고 방문처리
                    if(color != 'B' && arr[newR][newC] != 'B') {
                        q.offer(new Pos(newR, newC));
                        visited[newR][newC] = true;
                    } else if(color == 'B' && arr[newR][newC] == 'B') {
                        q.offer(new Pos(newR, newC));
                        visited[newR][newC] = true;
                    }
                }
            }
            area++; // 큐에 넣었던 [r][c]의 색깔 구역에 해당함
            // r, c 증가시키면서 방문 안 한 위치 찾기
            int[] notVisited = findNotVisited();
            r = notVisited[0];
            c = notVisited[1];
        }

        System.out.print(area);


    }
    static boolean isValid(int r, int c) {
        if(r<0 || r>=N || c<0 || c>=N) {
            return false;
        }
        return true;
    }
    static int[] findNotVisited() {
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(visited[r][c]) {
                    continue;
                }
                return new int[] {r, c};
            }
        }
        return new int[] {-1, -1};
    }
}
