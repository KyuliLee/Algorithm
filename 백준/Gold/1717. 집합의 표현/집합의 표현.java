import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[1000001];
        for(int i=0; i<=1000000; i++) {
            p[i] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 0) {
                union(a, b);
            } else {
                int ra = find(a);
                int rb = find(b);
                if(ra == rb) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.print(sb);
    }
    static int find(int v) {
        if(p[v] < 0) {
            return v;
        }
        return p[v] = find(p[v]);
    }
    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x==y) {
            return false; // 두 점의 루트가 같아서 이미 같은 그룹에 있는 경우
        }
        if(x > y) {
            p[y] = x;
        } else {
            p[x] = y;
        }
        return true;
    }
}
