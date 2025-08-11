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

    // 이미 u와 v가 같은 그룹이라 합칠 필요가 없으면 false 리턴
    static boolean uni(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if(ru == rv) {
            return false;
        }
        arr[rv] = ru;
        return true;
    }
    static int find(int v) {
        if(arr[v] < 0) {
            return v;
        }
        int parent = arr[v];
        return arr[v] = find(parent); // 최적화 : 부모 값을 그냥 루트 값으로 반환하게 해버림
    }
}
