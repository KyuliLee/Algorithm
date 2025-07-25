import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] checked;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1]; // 인덱스 번호의 학생이 선택하는 학생을 저장
            visited = new boolean[N+1]; // 방문했는데 또 방문했으면 사이클
            checked = new boolean[N+1]; // 이 학생이 팀을 만들 수 있는지, 없는지 체크
            cnt = 0; // 팀을 만들 수 있는 학생 수 카운트

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            /*
            이번 학생이 이미 팀을 구성했는지, 못 하는지 체크했으면 넘어감
             */
            for(int i=1; i<=N; i++) {
                if(checked[i]) {
                    continue;
                }
                dfs(i);
            }
            sb.append(N-cnt).append("\n");

        }
        System.out.print(sb);
    }
    static void dfs(int curr) {
        // 이번 학생을 이미 방문했다면 사이클이므로 체크해줌
        if(visited[curr]) {
            checked[curr] = true;
            cnt++;
        } else {
            visited[curr] = true;
        }
        // 다음 학생이 체크되지 않았다면 dfs
        int next = arr[curr];
        if(!checked[next]) {
            dfs(next);
        }

        // 사이클을 다 돌고 나면 이 학생이 사이클든 아니든 체크해줌.
        checked[curr] = true;
    }
}
