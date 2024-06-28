package week6;

public class PGS_타켓_넘버 {
private int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        int i = 0;
        int sum = 0;
        dfs(numbers, target, i, sum);
        return cnt;
    }
    
    private void dfs(int[] numbers, int target, int i, int sum) {
        if(i == numbers.length) {
            if(sum == target) {
                cnt++;
                return;
            } else {
                return;
            }
        }
        
        int sum1 = sum + numbers[i];
        int sum2 = sum - numbers[i];
        i++;
        dfs(numbers, target, i, sum1);
        dfs(numbers, target, i, sum2);
    }
}
