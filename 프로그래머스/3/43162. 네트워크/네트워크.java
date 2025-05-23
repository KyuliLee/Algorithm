import java.util.*;
class Solution {
    static List<Integer>[] list;
    static int size;
    static boolean[] visited;
    static int cnt = 0;
    
    public int solution(int n, int[][] computers) {
        size = computers.length;
        visited = new boolean[size];
        list = new ArrayList[size];
        for(int i=0; i<size; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<size; i++) {
            int[] conn = computers[i];
            for(int j=i+1; j<size; j++) {
                if(conn[j]==1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        } // 초기화 완료
        
        for(int i=0; i<size; i++) {
            if(!visited[i]) {
                cnt++;
                visited[i] = true;
                dfs(i);
            }
        }
        return cnt;
    }
    static void dfs(int com) {
        List<Integer> network = list[com];
        
        for(int i=0; i<network.size(); i++) {
            int n = network.get(i);
            if(!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
        
    }
}