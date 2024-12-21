import java.util.*;
class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int cnt = 0;
    
    public int solution(int n, int[][] computers) {
        graph = new List[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(computers[i][j]==1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        } // 그래프 초기화 완료
        
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                cnt++;
                visited[i] = true;
                
                for(int com : graph[i]) {
                    dfs(com);
                }
            }
        }
        
        return cnt;
    }
    static void dfs(int com) {
        visited[com] = true;
        for(int newCom : graph[com]) {
            if(!visited[newCom]) {
                dfs(newCom);
            }
        }
    }
}