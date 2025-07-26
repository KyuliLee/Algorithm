import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        int M = N/2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int size = map.size();
        if(size >= M) {
            return M;
        }
        return size;
    }
}