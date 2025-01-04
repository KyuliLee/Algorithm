import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0; // 절단기 높이 최댓값
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) {max = arr[i];}
        }// 초기화 완료
/*
적어도 M미터의 나무를 집에 가져가기 : 절단기 높이의 최댓값 구하기 -> upper bound
 */
        int min = 0; // 절단기 높이 최솟값
        while(min < max) {
            int mid = (max+min)/2; // 현재 절단기 높이
            long tree = 0;
            for(int i=0; i<N; i++) {
                if(arr[i] > mid) {
                    tree += arr[i] - mid;
                }
            }
//            System.out.println(tree);
/*
현재 절단기 높이로 잘랐을 때 가져가는 나무의 길이가 M보다 작다면 절단기 높이를 내려야 함. max를 감소시킴
만약 ~~가 M보다 크거나 같다면 절단기 높이를 키워야 함. min을 높이자.
 */
            if(tree < M) {
                max = mid;
            } else {
                min = mid+1; // mid로 하면 이미 M보다 크거나 같다는 것을 확인했기 때문에 min을 mid+1로 놓는다
            }
        }
        System.out.println(min-1);

    }
}