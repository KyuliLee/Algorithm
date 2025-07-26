import java.util.*;
class Solution {
    static int N;
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        visited = new boolean[N];
        
        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(list);
        // System.out.println(list.get(0));
        
        return list.get(0).split(" ");
    }
    void dfs(String[][] tickets, String path, String departure, int depth) {
        if(depth == N) {
            list.add(path);
            return;
        }
        for(int i=0; i<N; i++) {
            if(visited[i]) {continue;}
            if(tickets[i][0].equals(departure)) {
                visited[i] = true;
                String newPath = path + " " + tickets[i][1];
                dfs(tickets, newPath, tickets[i][1], depth+1);
                visited[i] = false;
            }
        }
        
        
    }
}