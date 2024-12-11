package week8;
import java.util.*;

public class PGS_모음사전 {
    
    private static char[] alp = {'A', 'E', 'I', 'O', 'U'};
    private static int cnt = 0;
    private static int flag = -1;
    
      public int solution(String word) {
        
        dfs(word, "");

        return cnt;
    }
    
    public void dfs(String word, String str) {
        
        // 종료 조건 : str의 길이가 6일 때, str이 word와 같을 때
        if(str.length() > 5) return;
        if(flag == 0) return;
        
        if(str.equals(word)) {
            flag = 0;
            return;
        }
        
        cnt++;
        
        for(int i=0; i<alp.length; i++) {
            dfs(word, str+alp[i]);
        }
        
    }
}