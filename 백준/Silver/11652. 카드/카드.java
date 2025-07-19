import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        int[] cntArr = new int[N];
        cntArr[0] = 1;

        long max = arr[0];
        int maxCnt = 1;
        for(int i=1; i<N; i++) {
            if(arr[i] == arr[i-1]) {
                cntArr[i] = cntArr[i-1]+1;
                if(maxCnt < cntArr[i]) {
                    maxCnt = cntArr[i];
                    max = arr[i];
                }
            } else {
                cntArr[i] = 1;
            }
        }
        System.out.print(max);
    }
}