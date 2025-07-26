import java.util.*;

class Solution {
    static int cnt = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        // 컴퓨터는 0부터 시작
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++) {
            int[] conn = computers[i];
            for(int j=i+1; j<n; j++) {
                if(conn[j] == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        } // 그래프 초기화 완료
        
        for(int i=0; i<n; i++) {
            if(visited[i]) { continue; }
            cnt++;
            dfs(i);
        }
        
        return cnt;
    }
    void dfs(int curr) {
        visited[curr] = true;
        ArrayList<Integer> list = graph[curr];
        for(int n : list) {
            if(visited[n]) {
                continue;
            }
            dfs(n);
        }
    }
}