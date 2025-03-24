import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int r;
    int c;
    int date;
    public Tomato(int r, int c, int date) {
        this.r = r;
        this.c = c;
        this.date = date;
    }
}
public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 칸 수가 먼저 주어짐
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        // 최초로 1인 토마토를 큐에 넣고 방문처리
        // 큐에서 빼면서 사방탐색, 0인 토마토 큐에 넣고 방문처리
        // -1인 위치는 방문처리
        boolean isAllTomatosRipe = true;
        Queue<Tomato> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    isAllTomatosRipe = false;
                } else if(arr[i][j] == 1) {
                    q.offer(new Tomato(i, j, 0));
                    visited[i][j] = true;
                } else {
                    visited[i][j] = true;
                }
            }
        } // 초기화 완료

        // 처음부터 모든 토마토가 익어있는 상태면 0 출력 후 리턴
        if(isAllTomatosRipe) {
            System.out.println(0);
            return;
        }

        // 큐에서 토마토 빼서 사방탐색하다가
        // 큐 비워지면 visited 돌면서 false인 곳이 있으면 -1 출력, 아니면 min 출력
        // min은 토마토의 date의 최댓값
        while(!q.isEmpty()) {
            Tomato curr = q.poll();
            min = Math.max(min, curr.date);
            for(int d=0; d<4; d++) {
                int newR = curr.r+dr[d];
                int newC = curr.c+dc[d];

                if(newR<0 || newR>=N || newC<0 || newC>=M || visited[newR][newC]) {
                    continue;
                }
                if(arr[newR][newC]==0) {
                    visited[newR][newC] = true;
                    q.offer(new Tomato(newR, newC, curr.date+1));
                } else if(arr[newR][newC] == -1) { // 초기화할 때 했겠지만 그래도 다시 확인..
                    visited[newR][newC] = true;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(min);

    }
}