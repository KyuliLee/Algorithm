class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0+numbers[0], 1);
        dfs(numbers, target, 0-numbers[0], 1);
        return cnt;
    }
    void dfs(int[] numbers, int target, int sum, int depth) {
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