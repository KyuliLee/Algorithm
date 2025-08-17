import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static long cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        getSumOfSubsequence(N/2, 0, 0, leftList); // 0 <= < N/2까지 부분수열의 합을 leftList에 저장
        getSumOfSubsequence(N, 0, N/2, rightList); // N/2 <= < N까지 부분수열의 합을 rightList에 저장

        // list들 정렬
        Collections.sort(leftList);
        Collections.sort(rightList);

        // 왼쪽 부분수열의 합, 오른쪽 부분수열의 합들을 하나씩 더하면서 S와 같으면 cnt증가
        int pl = 0;
        int pr = rightList.size()-1;

        while(pl < leftList.size() && pr >= 0) {
            int sum = leftList.get(pl) + rightList.get(pr);

            if(sum == S) {
                // 정렬한 상태이므로 pl의 오른쪽과 pr의 왼쪽에 pl, pr번째 요소와 같은 값들이 있을 수 있다. 그 둘을 교차로 더하는 만큼 cnt 증가
                int leftValue = leftList.get(pl);
                long cntL = 0;
                while(pl<leftList.size() && leftList.get(pl) == leftValue) {
                    cntL++;
                    pl++;
                }

                int rightValue = rightList.get(pr);
                long cntR = 0;
                while(pr >= 0 && rightList.get(pr) == rightValue) {
                    cntR++;
                    pr--;
                }
                cnt += (cntL * cntR);
            } else if(sum < S) {
                pl++;
            } else {
                pr--;
            }
        }

        // 만약 S가 0이라면 왼쪽 부분수열에서 공집합, 오른쪽 부분수열에서 공집합이 있어서 둘을 더한 경우는 값이 0이지만 수열의 크기가 양수가 아니므로 1을 빼줌
        if(S==0) cnt--;

        System.out.println(cnt);

    }
    static void getSumOfSubsequence(int end, int sum, int depth, ArrayList<Integer> list) {
        if(depth == end) {
            list.add(sum);
            return;
        }
        getSumOfSubsequence(end, sum, depth+1, list);
        getSumOfSubsequence(end, sum+arr[depth], depth+1, list);
    }
}
