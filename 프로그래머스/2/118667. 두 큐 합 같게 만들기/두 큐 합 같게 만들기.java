import java.util.*;
class Solution {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0; long sum2 = 0;
        for(int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++) {
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        
        int maxWorkNum = queue1.length + queue2.length;
        long plus = sum1+sum2;
        long goal = plus/2;
        // 두 큐의 값들을 모두 더했을 때 홀수이면 원소 합을 같게 만들 수 없으므로 -1 리턴
        if(plus%2 == 1) {return -1;}
        
        int cnt = 0;
        // 횟수가 maxWorkNum+2보다 커지면 두 큐를 교환한 게 되고 그렇게 될 동안 두 큐의 원소의 합이 같은 경우가 없으므로 -1 리턴
        // 큐1 합이 큐2 합보다 크면 큐1에서 빼서 큐2에 넣기
        // 큐1 합이 큐2 합보다 작으면 큐2에서 빼서 큐1에 넣기
        // 예시 : 1 2 3 4 5 / 1 1 1 1 19 1 => 12번 만에 작업 완료
        while(cnt <= maxWorkNum+2) {
            if(sum1 > sum2) {
                int n = q1.poll();
                q2.offer(n);
                sum1 -= n; sum2 += n;
                cnt++;
                continue;
            }
            if(sum1 < sum2) {
                int n = q2.poll();
                q1.offer(n);
                sum1 += n; sum2 -= n;
                cnt++;
                continue;
            }
            if(sum1 == sum2) {return cnt;}
        }
        return -1;
    }
}