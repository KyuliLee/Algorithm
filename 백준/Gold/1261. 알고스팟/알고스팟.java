import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
내가 풀었던 미로에서 사방탐색을 하는 문제들은 거의 다 최단 경로룰 구하는 문제였다.
그래서 이 문제는 최단 경로를 구하는 문제가 아님에도 나도 모르게 최단 경로를 구하는 방법을 생각하고 있었다.
문제에서는 최소한으로 부수는 벽의 개수를 구하라고 해서 '벽을 최소로 부수면서 어떻게 최단 경로를 구하지?' 라고
틀리게 접근했다.
하지만 이 문제는 몇 칸 이동했는지는 저장하지 않아도 되고 부순 벽의 개수만 저장하면 되는 문제였다.
 */

class Node implements Comparable<Node> {
    int r;
    int c;
    int walls;
    public Node(int r, int c, int walls) {
        this.r = r;
        this.c = c;
        this.walls = walls;
    }

    // walls를 기준으로 오름차순 정렬
    @Override
    public int compareTo(Node o) {
        return this.walls - o.walls;
    }
}
public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 크기 M
        N = Integer.parseInt(st.nextToken()); // 세로 크기 N
        arr = new int[N][M]; // new int[세로 크기][가로 크기]
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        } // 초기화 완료
        System.out.println(bfs(0, 0));
    }
    static int bfs(int r, int c) {
        boolean[][] visit = new boolean[N][M];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(r, c, 0));
        visit[r][c] = true;

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int currR = curr.r;
            int currC = curr.c;
            int currWalls = curr.walls;
            // pq에서 poll한 값이 목적지면 리턴
            if(currR == N-1 && currC == M-1) {
                return currWalls;
            }

            for(int d=0; d<4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];

                // 새로운 위치 유효성 검사, 이미 방문한 곳이면 넘어감
                if(nr<0 || nc<0 || nr>=N || nc>=M || visit[nr][nc]) {
                    continue;
                }

                visit[nr][nc] = true;
                if(arr[nr][nc]==0) {
                    pq.offer(new Node(nr, nc, currWalls));
                } else {
                    pq.offer(new Node(nr, nc, currWalls+1));
                }
            }
        }
        return 0;
    }
}