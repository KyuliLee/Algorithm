import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int r;
    int c;
    int time;
    public Pos(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}
public class Main {
    static int N;
    static int M;
    static int T;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int gramR = -1;
        int gramC = -1;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    gramR = i;
                    gramC = j;
                }
            }
        } // 초기화 완료

        /* 문제
        (0, 0)에서 (N-1, M-1)로 가는 최단 시간 구하기
        0은 빈 공간, 1은 벽, 2는 그람. 그람을 만나면 벽 무제한으로 부수고 넘어갈 수 있음
        T시간 안에 도달하면 그 시간 출력, 그 안에 도달 못 하면 fail 출력
         */

        /* 풀이
        그람을 만나는 경우, 안 만나는 경우 중 빠른 것 알아내기
        그냥 bfs로 (N-1, M-1)까지 거리 vs
        그람 위치까지 가는 bfs + 그람 위치 (i, j)~(N-1, M-1) 거리 계산.
        둘 다 T 이내에 못 들어오면 fail 출력
         */

        // 1) 그냥 bfs로 목적지까지
        Queue<Pos> q1 = new LinkedList<>();
        q1.offer(new Pos(0, 0, 0));
        boolean[][] visited1 = new boolean[N][M];
        visited1[0][0] = true;
        int time1 = -1;
        while(!q1.isEmpty()) {
            Pos currPos = q1.poll();
            int currR = currPos.r;
            int currC = currPos.c;
            int time = currPos.time;

            if(time > T) {
                continue;
            }

            if(currR == N-1 && currC == M-1) {
                time1 = time;
                break;
            }
            for(int d=0; d<4; d++) {
                int newR = currR + dr[d];
                int newC = currC + dc[d];

                if(!isValid(newR, newC) || visited1[newR][newC]) {
                    continue;
                }
                if(arr[newR][newC] == 1) { // 벽은 못 지나감
                    continue;
                }
                q1.offer(new Pos(newR, newC, time+1));
                visited1[newR][newC] = true;
            }
        }
        // 2) 그람까지 bfs
        Queue<Pos> q2 = new LinkedList<>();
        q2.offer(new Pos(0, 0, 0));
        boolean[][] visited2 = new boolean[N][M];
        visited2[0][0] = true;
        int time2 = -1;
        while(!q2.isEmpty()) {
            Pos currPos = q2.poll();
            int currR = currPos.r;
            int currC = currPos.c;
            int time = currPos.time;

            if(time > T) {
                continue;
            }

            if(currR == gramR && currC == gramC) {
                time2 = time;
                break;
            }
            for(int d=0; d<4; d++) {
                int newR = currR + dr[d];
                int newC = currC + dc[d];

                if(!isValid(newR, newC) || visited2[newR][newC]) {
                    continue;
                }
                if(arr[newR][newC] == 1) { // 벽은 못 지나감
                    continue;
                }
                q2.offer(new Pos(newR, newC, time+1));
                visited2[newR][newC] = true;
            }
        }

        // time > T에서 break 했으니까 bfs1, bfs2에서 이미 시간이 T를 넘었으면 time이 -1로 고정됨

        if(time2 != -1) {
            time2 += (N-1)-gramR + (M-1)-gramC;
            if(time2 > T) {
                time2 = -1;
            }
        }

        if(time1 != -1 && time2 != -1) {
            System.out.println(Math.min(time1, time2));
        } else if (time1 == -1 && time2 == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(Math.max(time1, time2));
        }

    }
    public static boolean isValid(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}
