package week8;

class Solution {
    private static int sum = 0;
    private static int depth = 0;
    private static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, numbers[0], 1);
        dfs(numbers, target, numbers[0]*(-1), 1);
        return cnt;
    }
    
    public void dfs(int[] numbers, int target, int sum, int depth) {
        // 종료 조건
        if(depth == numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        dfs(numbers, target, sum+numbers[depth], depth+1);
        dfs(numbers, target, sum-numbers[depth], depth+1);
        
    }
}