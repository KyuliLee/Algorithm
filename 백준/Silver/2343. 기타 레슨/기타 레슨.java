import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
        } // 초기화 완료
        int low = max; // 최소
        int high = sum;
        while(low < high) {
            int mid = (low+high)/2; // mid 크기의 블루레이가 M개 있다
//            System.out.println(mid);
            // mid 크기만큼의 바구니에 동영상을 넣는데 바구니가 M개를 초과하면 mid를 키움
            int bucket = 1;
            int size = 0; // 최대 mid
            for(int i=0; i<N; i++) {
                if(bucket > M) {
                    break;
                }
                size += arr[i];
                // 현재 바구니에 들어간 영상들의 길이의 합이 mid를 초과하면 바구니를 1개 늘림
                if(size > mid) {
                    bucket++;
                    size = arr[i];
                }
            }
//            System.out.println("bucket : " + bucket + ", low : " + low);
            if(bucket > M) {
                low = mid+1;
            } else {
                high = mid;
            }
//            System.out.println("low : " + low + ", high : " + high);
        }
        System.out.println(low);
    }
}