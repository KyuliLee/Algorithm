import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (s1, s2) -> s1[1].compareTo(s2[1]));
        boolean[] visited = new boolean[tickets.length];
        list.add("ICN");
        dfs("ICN", visited, tickets);
        return list.toArray(new String[0]);
    }
    
    void dfs(String start, boolean[] visited, String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                list.add(tickets[i][1]);
                dfs(tickets[i][1], visited, tickets);    
            }
        }
    }
}