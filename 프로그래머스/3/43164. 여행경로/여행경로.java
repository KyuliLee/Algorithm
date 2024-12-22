import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static boolean[] isUsed;
    public String[] solution(String[][] tickets) {
        
        isUsed = new boolean[tickets.length];
        // ICN에서 시작하는 모든 경로를 탐색
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(list);
        System.out.println(list.get(0));
        
        return list.get(0).split(" ");
    }
    static void dfs(String departure, String path, String[][] tickets, int depth) {
        if(depth == tickets.length) {
            list.add(path);
            return;
        }
        for(int i=0; i<tickets.length; i++) {
            if(!isUsed[i] && tickets[i][0].equals(departure)) {
                isUsed[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth+1);
                
                isUsed[i] = false;
            }
        }
        
    }
}