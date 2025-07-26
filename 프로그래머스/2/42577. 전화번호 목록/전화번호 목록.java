import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        int N = phone_book.length;
        for(int i=0; i<N; i++) {
            set.add(phone_book[i]);
        }
        for(int i=0; i<N; i++) {
            String number = phone_book[i];
            int numberLen = number.length();
            for(int j=1; j<numberLen; j++) {
                String temp = number.substring(0, j);
                if(set.contains(temp)) { return false;}
            }
        }
        return true;
    }
}