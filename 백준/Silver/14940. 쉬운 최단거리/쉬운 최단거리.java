import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14940

class Node{
    int r;
    int c;
    int cnt;
    public Node(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}
public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] ans;
    static int[] dest = new int[2];
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        ans = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 목표 지점 초기화
                if(arr[i][j]==2) {
                    dest[0] = i;
                    dest[1] = j;
                }
            }
        } // 초기화 완료

        StringBuilder sb = new StringBuilder();
        // 목적지부터 시작해서 한 칸씩 옆으로 가면서 1씩 증가시킨 값을 ans에 저장
        bfs(dest[0], dest[1]);
        // ans 전체를 돌면서 sb에 append
        // 방문한 곳은 그 값 그대로, 방문 안 한 곳은 도달할 수 없는 위치이므로 -1을 append
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    sb.append(0).append(" ");
                } else {
                    if(visit[i][j]) {
                        sb.append(ans[i][j]).append(" ");
                    } else {
                        sb.append(-1).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 0));
        ans[r][c] = 0;
        visit = new boolean[n][m];
        visit[r][c] = true;

        while(!q.isEmpty()) {
            Node curr = q.poll();
            ans[curr.r][curr.c] = curr.cnt;
            for(int d=0; d<4; d++) {
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];

                // nr, nc가 유효하고, 방문을 안 했으면 방문 처리
                if(isValid(nr, nc) && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    // arr[nr][nc]가 1이면 큐에 넣음
                    if(arr[nr][nc] == 1) {
                        q.offer(new Node(nr, nc, curr.cnt+1));
                    }
                }
            }
        }
    }
    static boolean isValid(int r, int c) {
        if(r<0 || c<0 || r>=n || c>=m) return false;
        return true;
    }
}