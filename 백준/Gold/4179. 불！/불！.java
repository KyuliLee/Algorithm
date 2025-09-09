import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] arr;
    static Queue<int[]> fireQ = new ArrayDeque<>();
    static Queue<int[]> jhQ = new ArrayDeque<>();
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int time = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R+2][C+2];
        for(int i=1; i<=R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                char c = str.charAt(j);
                arr[i][j+1] = c;
                if(arr[i][j+1] == 'F') {
                    fireQ.offer(new int[] {i, j+1});
                } else if(arr[i][j+1] == 'J') {
                    jhQ.offer(new int[] {i, j+1, 0});
                }
            }
        }
        /*
        fireQ에서 현재 있는 애들 다 꺼내서 확산하면서 F 채우고 fireQ에 넣기 -> 지훈 갈 수 있는 곳에 J 채우고 jhQ에 넣기
        jhQ가 비면 종료
         */
        while(!jhQ.isEmpty()) {
            // 불 움직임
            int fireSize = fireQ.size();
            for(int i = 0; i< fireSize; i++) {
                int[] currFire = fireQ.poll();
                fireExpand(currFire[0], currFire[1]);
            }
            // 지훈 움직임
            int jhSize = jhQ.size();
            for(int i=0; i<jhSize; i++) {
                int[] currJH = jhQ.poll();
                int jhR = currJH[0];
                int jhC = currJH[1];
                int jhTime = currJH[2];
                if(jhR == 0 || jhR == R+1 || jhC == 0 || jhC == C+1) { // 현재 위치
                    System.out.println(jhTime);
                    return;
                }
                jhMove(jhR, jhC, jhTime);
            }

        }
        System.out.println("IMPOSSIBLE");

    }
    static public void jhMove(int r, int c, int time) {
        // 벽, 불이 아닌 곳에 갈 수 있으면 그 위치를 큐에 넣음
        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr<0 || nr>R+1 || nc<0 || nc>C+1) continue;
            if(arr[nr][nc] == '#' || arr[nr][nc] == 'F' || arr[nr][nc] == 'J') continue;
            arr[nr][nc] = 'J';
            jhQ.offer(new int[] {nr, nc, time+1});
        }
    }
    static public void fireExpand(int r, int c) {
        // 불이 확산할 수 있는 곳이면 확산하고 큐에 넣음
        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr<1 || nr>R || nc<1 || nc>C) continue;
            if(arr[nr][nc] == '#' || arr[nr][nc] == 'F') continue;
            arr[nr][nc] = 'F';
            fireQ.offer(new int[] {nr, nc});
        }
    }
}
