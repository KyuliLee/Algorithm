package week8;

class Solution {
    
    private static boolean[] visited;
    private static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        int cnt = 0;
        dfs(k, dungeons, 0);
        return max;
    
    }
    
    public void dfs(int k, int[][]dungeons, int cnt) {
        max = Math.max(max, cnt);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
    }
}
