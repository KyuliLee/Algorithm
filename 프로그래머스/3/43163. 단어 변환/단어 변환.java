import java.util.*;
class Word {
    String str;
    int cnt;
    public Word(String str, int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}
class Solution {
    static int N;
    static boolean[] visited;
    static char[] charArr;
    
    public int solution(String begin, String target, String[] words) {
        boolean haveTarget = false;
        for(String word : words) {
            if(word.equals(target)) {
                haveTarget = true;
                break;
            }
        }
        if(!haveTarget) {
            return 0;
        }
        N = words.length;
        visited = new boolean[N];
        charArr = begin.toCharArray();
        // begin단어를 한 글자씩 바꿔가면서 words에 있는지 확인
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        while(!q.isEmpty()) {
            Word currWord = q.poll();
            String tempWord = currWord.str;
            int cnt = currWord.cnt;
            if(tempWord.equals(target)) { return cnt; }
            // 큐에서 꺼낸 단어를 char배열로 만들고 이 중 알파벳 1개만 다른 단어가 word에 있다면 큐에 넣음
            charArr = tempWord.toCharArray();
            for(String word : words) {
                int diffNum = 0;
                for(int i=0; i<charArr.length; i++) {
                    if(word.charAt(i) == charArr[i]) { continue; }
                    diffNum++;
                }
                if(diffNum == 1) {
                    q.offer(new Word(word, cnt+1));
                }
            }
            
        }
        
        return -1;
    }
}