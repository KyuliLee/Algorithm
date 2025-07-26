import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        int participantNum = participant.length;
        for(int i=0; i<participantNum; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }
        for(int i=0; i<participant.length-1; i++) {
            String completer = completion[i];
            int num = map.get(completer);
            if(num == 1) {
                map.remove(completer);
            } else {
                map.put(completer, num-1);
            }
        }
        String ans = "";
        for(String s : map.keySet()) {
            ans = s;
        }
        return ans;
    }
}