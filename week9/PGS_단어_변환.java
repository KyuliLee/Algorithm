class PGS_단어_변환 {
    
    private static int result = 51;
    private static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return result==51 ? 0 : result;
    }
    
    public static void dfs(String begin, String target, String[] words, int depth) {
        
        if(begin.equals(target)) {
            result = Math.min(depth, result);
            return;
        } 
        
        for(int i=0; i<words.length; i++) {
            
            // 방문하지 않은 인덱스의 단어만 확인
            if(!visited[i]) { 
                // words 중 begin과 한 글자만 같은 게 있으면 dfs
                String word = words[i];
                int cnt = 0;
                for(int k=0; k<word.length(); k++) {
                    // word 길이만큼 begin과 앞에서부터 비교해서 1개만 다른지
                    if(begin.charAt(k) != word.charAt(k)) cnt++;
                }
                if(cnt==1) {
                    visited[i] = true;
                    dfs(words[i], target, words, depth+1);
                    visited[i] = false;
                }
            }
            
        }
        
    }
}
