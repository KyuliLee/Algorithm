import java.util.*;

class PGS_폰켓몬 {
    public int solution(int[] nums) {
        // nums의 값들을 Set에 넣어서 중복을 제거
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        if((nums.length/2) <= set.size()) {
            return nums.length/2;
        }
        return set.size();
    }
}