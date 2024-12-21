import java.util.*;
class Solution {
    static int N;
    public int solution(String begin, String target, String[] words) {
        N = words.length;
        // target이 words안에 없으면 0 리턴
        boolean isContained = false;
        for(int i=0; i<N; i++) {
            if(words[i].equals(target)) {
                isContained = true;
                break;
            }
        }
        if(!isContained) return 0;
        
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[] {begin, "0"});
        boolean[] visited = new boolean[N];
        
        while(!q.isEmpty()) {
            String[] currStr = q.poll();
            String str = currStr[0];
            String cntStr = currStr[1];
            int cnt = Integer.parseInt(cntStr);
            
            
            if(str.equals(target)) {
                return cnt;
            }
            
            // words를 돌면서 한 글자만 다른 단어를 큐에 넣고 방문 체크
            for(int i=0; i<N; i++) {
                if(!visited[i]) {
                    if(ifOnlyOneDiff(str, words[i])) {
                        visited[i] = true;
                        q.offer(new String[] {words[i], String.valueOf(cnt+1)});
                    }
                }
            }
        }
        return 100;
    }
    static boolean ifOnlyOneDiff(String str1, String str2) {
        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();
        int diffNum = 0;
        for(int i=0; i<chArr1.length; i++) {
            if(diffNum>=2) break;
            if(chArr1[i] != chArr2[i]) diffNum++;
        }
        if(diffNum==1) return true;
        return false;
    }
}