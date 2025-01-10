import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        // for문 돌리면 오래 걸리니까 map으로 선수 인덱스 빠르게 찾기
        Map<String, Integer> map = new HashMap<>(); 
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        for(String p : callings) {
            int idx = map.get(p);
            String prev = players[idx-1];
            // 위치 교환
            players[idx-1] = p;
            players[idx] = prev;
            map.put(p, idx-1);
            map.put(prev, idx);
        }
        return players;
    }
}