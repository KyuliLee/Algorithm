import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
//    static int[][] arr;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
//        arr = new int[N][N];
        list = new ArrayList[N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<>();
            for(int j=0; j<N; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
                int temp = Integer.parseInt(st.nextToken());
                if(temp==1) {
                    // 방향 그래프이므로 i->j 만 저장
                    list[i].add(j);
                }
            }
        } // 초기화 완료
        int[][] ans = new int[N][N];
        for(int r=0; r<N; r++) {
            // r->c로 가는 경로가 있는지 확인
            for(int c=0; c<N; c++) {
                // r->c 경로가 바로 있으면 1로 갱신
                if(list[r].contains(c)) {
                    ans[r][c] = 1;
                    continue;
                }
                // 만약 없다면 타고타고 가야함
                if(bfs(r, c)) {
                    ans[r][c] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] arr : ans) {
            for(int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static boolean bfs(int r, int c) {
        boolean[] visited = new boolean[N];
        boolean flag = false;
        // 해당 row의 arraylist에 있는 값을 큐에 넣는다.
        // 큐가 빌 때까지 반복
        Queue<Integer> q = new LinkedList<>();
        visited[r] = true;
        for(int n : list[r]) {
            q.offer(n);
        }
        while(!q.isEmpty()) {
            int s = q.poll();
            // 이미 방문했던 열이면 넘어감
            if(visited[s]) {
                continue;
            }
            visited[s] = true;
            if(list[s].contains(c)) {
                return true;
            }
            for(int n : list[s]) {
                q.offer(n);
            }
        }
        return false;
    }
}