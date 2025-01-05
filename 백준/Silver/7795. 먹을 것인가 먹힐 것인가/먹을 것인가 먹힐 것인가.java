import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B); // 초기화 완료

            int pairNum = 0;
            for(int i=0; i<N; i++) {
                int num = A[i];
                int low = 0;
                int high = M-1;

                while(low < high) {
                    int mid = (low+high)/2;

                    if(B[mid] < num) {
                        low = mid+1;
                    } else {
                        high = mid;
                    }
                }
                if(B[low] == num) {
                    pairNum += low;
                } else if(B[low] < num) {
                    pairNum += low+1;
                } else {
                    pairNum += low;
                }
            }
            System.out.println(pairNum);
        }
    }
}