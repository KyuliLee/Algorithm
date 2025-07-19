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
        Arrays.sort(arr); // arr 오름차순 정렬
        int[] cntArr = new int[N]; // arr 배열에서 동일한 인덱스에 있는 숫자의 카드 개수를 저장
        cntArr[0] = 1; // arr[0]에 있는 숫자는 1개이므로 cntArr[0]에 1 저장

        long max = arr[0];
        int maxCnt = 1; // 지금까지 최댓값의 개수는 1개
        for(int i=1; i<N; i++) {
            // 이번 숫자가 직전 숫자와 같다면 cntArr의 이번 인덱스에 직전 인덱스 값보다 1 증가시켜서 저장
            // 현재까지 가장 여러 번 나온 횟수가 이번 숫자 카드의 횟수보다 작다면 maxCnt, max 갱신
            if(arr[i] == arr[i-1]) {
                cntArr[i] = cntArr[i-1]+1;
                if(maxCnt < cntArr[i]) {
                    maxCnt = cntArr[i];
                    max = arr[i];
                }
            } else { // arr를 정렬시켜놨기 때문에 arr[i]와 arr[i-1]이 다르다면 무조건 arr[i]이 크다
                cntArr[i] = 1;
            }
        }
        System.out.print(max);
    }
}