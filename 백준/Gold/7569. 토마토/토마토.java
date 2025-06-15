import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int r;
    int c;
    int h;
    public Pos(int r, int c, int h) {
        this.r = r;
        this.c = c;
        this.h = h;
    }
}
public class Main {
    static int N;
    static int M;
    static int H;
    static int[][][] arr;
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boolean RawTomatoExists = false;
        Queue<Pos> ripeTomatos = new LinkedList<>();
        arr = new int[N][M][H];
        boolean[][][] visited = new boolean[N][M][H];
        for(int h=0; h<H; h++) {
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    arr[i][j][h] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][h] == 0) {
                        RawTomatoExists = true;
                        continue;
                    }
                    if(arr[i][j][h] == 1) {
                        ripeTomatos.offer(new Pos(i, j, h));
                        visited[i][j][h] = true;
                    }
                }
            }
        } // 초기화 완료

        if(!RawTomatoExists) {
            System.out.println(0);
            return;
        }

        /* 문제
        N : 행, M : 열, H : 높이 / 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토가 들어 있지 않음
        토마토가 인접한 곳 : 위, 아래, 왼쪽, 오른쪽, 앞, 뒤, 총 6방향
        보관된 토마토가 며칠이 지나면 다 익는 최소 일수 구하기
        만약 처음부터 모든 토마토가 다 익어있으면 0, 모든 토마토가 익지는 못하는 상황이면 -1 출력
         */

        /* 풀이
        익은 토마토를 큐에 넣고 방문 처리. 큐가 빌 때까지 반복
            큐에 있는 요소 사이즈만큼 반복. day 1 증가
                큐에서 토마토 위치 하나 빼고 육방탐색. 갈 수 있으면 큐에 넣고 방문 처리.
        큐 반복이 끝나면 배열을 모두 다 돌면서 0이 있는지 확인. 있으면 -1 출력, 없으면 day 출력
        방문처리를 하지 않고, 방문한 0 토마토를 1로 바꿔버리기
         */

        int day = 0;
        while(!ripeTomatos.isEmpty()) {
            int size = ripeTomatos.size();
            day++;
            for(int elem=0; elem<size; elem++) {
                Pos currPos = ripeTomatos.poll();

                for(int d=0; d<6; d++) {
                    int newR = currPos.r+dr[d];
                    int newC = currPos.c+dc[d];
                    int newH = currPos.h+dh[d];

                    if(isValid(newR, newC, newH)) {
                        ripeTomatos.offer(new Pos(newR, newC, newH));
                        arr[newR][newC][newH] = 1;
                    }
                }
            }
        }

        boolean isAllTomatosRipe = true;
        for(int h=0; h<H; h++) {
            for(int r=0; r<N; r++) {
                for(int c=0; c<M; c++) {
                    if(arr[r][c][h] == 0) {
                        isAllTomatosRipe = false;
                        break;
                    }
                }
                if(!isAllTomatosRipe) {
                    break;
                }
            }
            if(!isAllTomatosRipe) {
                break;
            }
        }
        if(!isAllTomatosRipe) {
            System.out.println(-1);
        } else {
            System.out.println(--day);
        }

    }
    public static boolean isValid(int r, int c, int h) { // 상자를 벗어나지 않고 익지 않은 토마토가 있는 위치인지 확인
        return r>=0 && r<N && c>=0 && c<M && h>=0 && h<H && arr[r][c][h]==0;
    }
}
