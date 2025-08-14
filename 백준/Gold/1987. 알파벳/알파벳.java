import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static Set<Character> set = new HashSet<>();
    static char[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        set.add(arr[0][0]);
        visited[0][0] = true;

        dfs(0, 0, 1);
        System.out.println(max);

    }
    static void dfs(int r, int c, int moveNum) {

        for(int d=0; d<4; d++) {
            int newR = r+dr[d];
            int newC = c+dc[d];
            if(newR<0 || newR>=R || newC<0 || newC>=C) {
                max = Math.max(max, moveNum);
                continue;
            }
            if(set.contains(arr[newR][newC])) {
                max = Math.max(max, moveNum);
                continue;
            }
            set.add(arr[newR][newC]);
            dfs(newR, newC, moveNum+1);
            set.remove(arr[newR][newC]);
        }
    }
}