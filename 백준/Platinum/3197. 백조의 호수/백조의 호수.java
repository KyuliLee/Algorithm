import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, r1, c1, r2, c2, day = 0;
    static char[][] arr;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static Queue<int[]> birdsQ = new ArrayDeque<>(), nextBirdsQ = new ArrayDeque<>(), waterQ = new ArrayDeque<>();
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        Queue<Integer> birdsInitialPosQ = new ArrayDeque<>();
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'L') {
                    birdsInitialPosQ.offer(i);
                    birdsInitialPosQ.offer(j);
                }
                if(arr[i][j] == '.' || arr[i][j] == 'L') {
                    waterQ.offer(new int[] {i, j});
                }
            }
        }
        r1 = birdsInitialPosQ.poll();
        c1 = birdsInitialPosQ.poll();
        r2 = birdsInitialPosQ.poll();
        c2 = birdsInitialPosQ.poll();
        birdsQ.offer(new int[] {r1, c1}); // 하나만 넣고 나머지 하나는 도착 지점
        visited[r1][c1] = true;
        /*
        하루 지날 때마다 만날 수 있는지 확인하고 물이 녹는다
        만날 수 있는지 확인 : birdsQ를 돌면서 사방탐색하고 방문처리. 다음 위치(arr[nr][nc])가 .이면 birdsQ에 넣고 X면 nextBirdsQ에 넣음
        물이 녹음 : waterQ의 사이즈만큼 waterQ를 돌면서 사방탐색. 다음 위치가 X이면 방문 처리, 다음 번에 물이 될 것이므로 waterQ에 넣음
        day++
         */
        while(true) {
            if(canMeet()) {
                System.out.println(day);
                return;
            }
            iceToWater();
            birdsQ = nextBirdsQ;

            day++;
        }

    }
    static void iceToWater() {
        int size = waterQ.size();
        for(int i=0; i<size; i++) {
            int[] curr = waterQ.poll();
            int r = curr[0], c = curr[1];

            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]) continue;
                if(arr[nr][nc] == 'X') {
                    waterQ.offer(new int[] {nr, nc});
                    arr[nr][nc] = '.'; // 얼음을 물로 변경
                }
            }
        }
    }
    static boolean canMeet() {
        nextBirdsQ = new ArrayDeque<>();
        while(!birdsQ.isEmpty()) {
            int[] curr = birdsQ.poll();
            int r = curr[0], c = curr[1];

            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if(arr[nr][nc] == '.') birdsQ.offer(new int[] {nr, nc}); // 물이면 백조 이동 가능
                else if(arr[nr][nc] == 'L') return true; // 백조를 만났으면 true 리턴
                else if(arr[nr][nc] == 'X') nextBirdsQ.offer(new int[] {nr, nc}); // 얼음이면 지금은 못 가고 다음 번에 갈 수 있다.
            }
        }

        return false;
    }
}