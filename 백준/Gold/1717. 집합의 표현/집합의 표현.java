import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[1000001];
        for(int i=0; i<=1000000; i++) {
            arr[i] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<m; tc++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 0) {
                uni(a, b);
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
        System.out.println(sb);

    }

    static void uni(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if(ru == rv) {
            return;
        }
        arr[rv] = ru;
    }
    static int find(int v) {
        if(arr[v] == -1) {
            return v;
        }
        int parent = arr[v];
        return find(parent);
    }
}
