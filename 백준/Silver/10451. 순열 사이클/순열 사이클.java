import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<T; tc++) {
            cnt = 0;
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            } // 초기화 완료

            for(int i=1; i<=N; i++) {
                if(visited[i]) {
                    continue;
                }
                int next = arr[i];
                while(!visited[next]) {
                    visited[next] = true;
                    next = arr[next];
                }
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
