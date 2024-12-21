class Solution {
    static int cnt = 0;
    static int N;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        int n = numbers[0];
        dfs(numbers, target, 0, 0);
    
        return cnt;
    }
    static void dfs(int[]numbers, int target, int curr, int depth) {
        // 종료 조건
        if(depth == N) {
            if(curr == target) cnt++;
            return;
        }
        // 재귀 부분
        int n = numbers[depth];
        dfs(numbers, target, curr+n, depth+1);
        dfs(numbers, target, curr-n, depth+1);
    }
}