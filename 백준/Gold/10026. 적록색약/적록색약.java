import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int r;
    int c;
    char color;
    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static char[][] arr;
    static char[][] arrBlind;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new char[N][N];
        arrBlind = new char[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 'R') {
                    arrBlind[i][j] = 'G';
                } else if(arr[i][j] == 'G' || arr[i][j] == 'B') {
                    arrBlind[i][j] = arr[i][j];
                }
            }
        }
        // 초기화 완료
        /*
        [0][0]부터 시작해서 완탐. BFS로 사방탐색하면서 글자들의 영역 개수 찾기.
         */
        // 1. 적록색약이 아닌 사람
        int area = 0;
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    area++;
                }
            }
        }
        System.out.print(area+" ");

        area = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfsBlind(i, j);
                    area++;
                }
            }
        }
        System.out.print(area);

    }
    static void dfs(int r, int c) {
        visited[r][c] = true;

        for(int d=0; d<4; d++) {
            int newR = r + dr[d];
            int newC = c + dc[d];
            if(!isValid(newR, newC) || visited[newR][newC]) {
                continue;
            }
            if(arr[r][c] == arr[newR][newC]) {
                visited[newR][newC] = true;
                dfs(newR, newC);
            }
        }
    }

    static void dfsBlind(int r, int c) {
        visited[r][c] = true;

        for(int d=0; d<4; d++) {
            int newR = r + dr[d];
            int newC = c + dc[d];
            if(!isValid(newR, newC) || visited[newR][newC]) {
                continue;
            }
            if(arrBlind[r][c] == arrBlind[newR][newC]) {
                visited[newR][newC] = true;
                dfsBlind(newR, newC);
            }
        }
    }
    static boolean isValid(int r, int c) {
        if(r<0 || r>=N || c<0 || c>=N) {
            return false;
        }
        return true;
    }
}
