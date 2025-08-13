import org.w3c.dom.css.Rect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Rectangle {
    int x1, y1, x2, y2;
    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
public class Main {
    static int N;
    static Rectangle[] recs;
    static boolean[] visited;
    static int cnt = 0;
    static boolean isZeroZeroMeet = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        recs = new Rectangle[N+1]; // 0번째 방은 시작점 (0,0,0,0)으로 둔다
        recs[0] = new Rectangle(0, 0, 0, 0);
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            Rectangle rec = new Rectangle(x1, y1, x2, y2);
            recs[i] = rec;
        }

        /*
        0. Rectangle 클래스로 4개의 꼭짓점 저장, Rectangle 타입의 배열 만듦
        1. dfs로 두 개의 사각형을 비교해서 겹치는 부분 있는지 확인
        2. 안 겹치는 조건 : OR
            1번 사각형의 오른쪽 좌표가 2번 사각형의 왼쪽 좌표보다 작음
            1번 사각형의 왼쪽 좌표가 2번 사각형의 오른쪽 좌표보다 큼
            1번의 위 좌표가 2번의 아래 좌표보다 작음
            1번의 아래 좌표가 2번의 위 좌표보다 큼
            한 사각형 내부에 다른 사각형이 들어가 있음
         */

        visited[0] = true;
        dfs(0); // 원점을 지나가는 사각형의 경우를 먼저 확인

        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i);
            cnt++;
        }

        System.out.println(cnt);

    }
    static void dfs(int r1) {
        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;
            // 겹치는 사각형이면 방문처리하고 dfs
            if(isOverlap(recs[r1], recs[i])) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
    static boolean isOverlap(Rectangle r1, Rectangle r2) {
        // 사각형에서 가장 왼, 오, 위, 아래 좌표 찾기
        int r1Left = Math.min(r1.x1, r1.x2);
        int r1Right = Math.max(r1.x1, r1.x2);
        int r1Top = Math.max(r1.y1, r1.y2);
        int r1Bottom = Math.min(r1.y1, r1.y2);

        int r2Left = Math.min(r2.x1, r2.x2);
        int r2Right = Math.max(r2.x1, r2.x2);
        int r2Top = Math.max(r2.y1, r2.y2);
        int r2Bottom = Math.min(r2.y1, r2.y2);

        // 두 사각형 위치가 아예 다른 경우
        if(r1Right < r2Left || r1Left > r2Right || r1Top < r2Bottom || r1Bottom > r2Top) {
            return false;
        }
        // r1이 더 커서 r1 안에 r2 있는 경우
        if(r2Left > r1Left && r2Left < r1Right && r2Right > r1Left && r2Right < r1Right &&
            r2Top > r1Bottom && r2Top < r1Top && r2Bottom > r1Bottom && r2Bottom < r1Top) {
            return false;
        }
        // r2가 더 커서 r2 안에 r1 있는 경우
        if(r1Left > r2Left && r1Left < r2Right && r1Right > r2Left && r1Right < r2Right &&
            r1Top > r2Bottom && r1Top < r2Top && r1Bottom > r2Bottom && r2Bottom < r2Top) {
            return false;
        }

        return true;
    }
}
