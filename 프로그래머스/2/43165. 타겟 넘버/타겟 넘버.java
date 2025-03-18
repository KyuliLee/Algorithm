class Solution {
    static int cnt = 0;
    static int size;
    static boolean[] visit;
    public int solution(int[] numbers, int target) {
        size = numbers.length;
        visit = new boolean[size];
        
        dfs(numbers, target, 0, 0);
        
        return cnt;
    }
    static void dfs(int[] numbers, int target, int cal, int depth) {
        if(depth == size) {
            if(cal == target) {
                cnt++;
            }
            return;
        }
        
        int n = numbers[depth];
        dfs(numbers, target, cal+n, depth+1);
        dfs(numbers, target, cal-n, depth+1);
    }
}