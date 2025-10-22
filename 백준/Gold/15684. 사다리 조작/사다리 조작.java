import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, min = Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        if(M == 0) {
            System.out.println(0);
            return;
        }
        visited = new boolean[H+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited[a][b] = true;
        }
        func(1, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }
    static boolean check() {
        for(int n=1; n<=N; n++) {
            int pos = n;
            for(int h=1; h<=H; h++) {
                if(visited[h][pos]) pos++;
                else if(visited[h][pos-1]) pos--;
            }
            if(pos != n) return false;
        }
        return true;
    }
    static void func(int curr, int cnt) {
        if(cnt>3 || cnt>=min) return;
        if(check()) {
            min = Math.min(min, cnt);
            return;
        }
        for(int h=curr; h<=H; h++) {
            for(int n=1; n<N; n++) {
                if(visited[h][n] || visited[h][n-1] || visited[h][n+1]) continue;
                visited[h][n] = true;
                func(h, cnt+1);
                visited[h][n] = false;
            }
        }
    }
}
