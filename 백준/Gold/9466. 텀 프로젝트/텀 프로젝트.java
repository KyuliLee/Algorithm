import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finish;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<TC; tc++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N +1];
            visited = new boolean[N+1];
            finish = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=N; i++) {
                // 이미 팀이 되는지, 안 되는지 정해진 학생이면 넘어감
                if(finish[i]) {
                    continue;
                }
                dfs(i);
            }
            sb.append(N-cnt).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int n) {
        if(finish[n]) {
            return;
        }
        if(visited[n]) { // 이미 방문했는데 또 왔으면 사이클 == 팀 만듦
            finish[n] = true;
            cnt++;
        }
        visited[n] = true;
        int next = arr[n];

        if(!finish[next]) {
            dfs(next);
        } {
            finish[n] = true; // 내가 선택한 학생이 이미 팀이라면 나는 팀을 못 만드므로 바로 true로 바꿔줌
        }
        finish[n] = true; // 사이클 다 돌고 나서는 팀 못 만든 학생도 true로 갱신
    }
}
