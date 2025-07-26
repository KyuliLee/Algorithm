import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호를 map에 넣고 substring으로 containsKey로 찾는다
        Map<String, Integer> map = new HashMap<>();
        int N = phone_book.length;
        for(int i=0; i<N; i++) {
            map.put(phone_book[i], 0);
        }
        for(int i=0; i<N; i++) {
            String phone = phone_book[i];
            int numberLen = phone.length();
            for(int j=1; j<numberLen; j++) {
                String temp = phone.substring(0, j);
                if(map.containsKey(temp)) {
                    return false;
                }
            }
        }
        return true;
    }
}