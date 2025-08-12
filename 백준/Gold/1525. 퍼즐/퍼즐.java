import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
    int r;
    int c;
    int cnt;
    String value;
    public Pos(int r, int c, int cnt, String value) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.value = value;
    }
}
public class Main {
    static int[][] arr = new int[3][3];
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int zeroR = -1;
        int zeroC = -1;
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    zeroR = i;
                    zeroC = j;
                }
            }
        }
        /*
        빈 칸은 bfs로 이동
        빈 칸(0)이 움직인 후 3x3 배열을 String으로 바꿔서 Map의 키로, 그 때까지 움직인 횟수를 value로 넣음
        만약 map에 해당 key가 있다면 그대로 종료, 만약 없다면 계속 진행
        움직인 후가 123456780 라면 그 때의 횟수 출력
         */

        String initial = changeToString();
        Map<String, Integer> map = new HashMap<>();
        map.put(initial, 0);
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(zeroR, zeroC, 0, initial));

        while(!q.isEmpty()) {
            Pos pos = q.poll();
            String origin = pos.value;
            // 123456780으로 배치되었는지 확인

            if(origin.equals("123456780")) {
                System.out.println(pos.cnt);
                return;
            }
            // 빈 칸 이동 후 어떻게 변했는지 알기 위해서 string을 int형 2차원 배열로 늘린다
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    arr[i][j] = origin.charAt(i*3+j)-'0';
                }
            }
            for(int d=0; d<4; d++) {
                int newR = pos.r + dr[d];
                int newC = pos.c + dc[d];
                if(!isValid(newR, newC)) continue;
                // newR, newC와 빈 칸 자리 바꾸기
                arr[pos.r][pos.c] = arr[newR][newC];
                arr[newR][newC] = 0;
                String changed = changeToString();

                // 다음 newR, newC도 자리 바꿔야 하니까 원상복귀
                arr[newR][newC] = arr[pos.r][pos.c];
                arr[pos.r][pos.c] = 0;

                // 이미 이동했던 위치이면 넘어감
                if (map.containsKey(changed)) {
                    continue;
                }
                q.offer(new Pos(newR, newC, pos.cnt+1, changed));
                map.put(changed, pos.cnt+1);

            }
        }
        System.out.println(-1);

    }
    static String changeToString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                sb.append(arr[i][j]);
            }
        }
        return String.valueOf(sb);
    }
    static boolean isValid(int r, int c) {
        if(r<0 || r>=3 || c<0 || c>=3) {
            return false;
        }
        return true;
    }
}
