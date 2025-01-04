import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int M = Integer.parseInt(br.readLine());
            int[] targets = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                targets[i] = Integer.parseInt(st.nextToken());
            } // 초기화 완료

            for(int target : targets) {
                if(bs(target, arr)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
    static boolean bs(int target, int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] == target) {
                return true;
            }
            if(arr[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}