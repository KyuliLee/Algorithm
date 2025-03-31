import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        // 이분탐색
        int left = 987654321;
        int right = 0;
        int len = stones.length;
        int[] temp = new int[len];
        for(int i=0; i<len; i++) {
            if(left > stones[i]) {
                left = stones[i];
            }
            if(right < stones[i]) {
                right = stones[i];
            }
        }
        int mid = (left+right)/2;
        while(left<=right) {
            for(int i=0; i<len; i++) {
                temp[i] = stones[i]-mid;
            }
            int cnt = 0; // 한 구간에서 뛰어넘는 돌의 수
            int stoneMax = 0; // 한 구간에서 뛰어넘는 돌의 수의 최댓값
            for(int i=0; i<len; i++) {
                if(temp[i]<=0) {
                    cnt++;
                    stoneMax = Math.max(stoneMax, cnt);
                } else {
                    cnt = 0;
                }
            }
            // 건너뛰는 돌의 개수가 k개가 넘으면 max를 줄여야 한다.
            // k개보다 작으면 min을 키워야 한다.
            // k개이면 mid리턴
            // 결과 mid일 때 k개 건너뛸 수 있다. mid명까지 건널 수 있음
            if(stoneMax > k) {
                right = mid-1;
            } else if(stoneMax < k) {
                left = mid+1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}