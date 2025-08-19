import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int target, m, n;
    static int[] circleA, circleB, sumA, sumB, cntA, cntB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        circleA = new int[2*m+1]; // 피자라서 순환이 가능. 만약 5조각일 때 5번째 조각과 1번째 조각을 함께 구매할 수도 있음
        circleB = new int[2*n+1];
        for(int i=1; i<=m; i++) {
            circleA[i] = Integer.parseInt(br.readLine());
            circleA[m+i] = circleA[i];
        }
        for(int i=1; i<=n; i++) {
            circleB[i] = Integer.parseInt(br.readLine());
            circleB[n+i] = circleB[i];
        }

        // 누적합 구하기
        sumA = new int[2*m+1];
        sumA[1] = circleA[1];
        for(int i=2; i<=2*m; i++) {
            sumA[i] = sumA[i-1] + circleA[i];
        }
        sumB = new int[2*n+1];
        sumB[1] = circleB[1];
        for(int i=2; i<=2*n; i++) {
            sumB[i] = sumB[i-1] + circleB[i];
        }

        // 빈도를 나타내는 배열
        cntA = new int[target+1];
        cntB = new int[target+1];
        makeArr(cntA, sumA, m);
        makeArr(cntB, sumB, n);

        int ans = 0;
        ans += cntA[target];
        ans += cntB[target];
        for(int i=1; i<target; i++) {
            int a = cntA[i];
            int b = cntB[target-i];
            ans += (a*b);
        }
        System.out.println(ans);
    }
    static void makeArr(int[] arr, int[] sum, int size) {
        for(int i=1; i<size; i++) { // 몇 개 조각을 선택할지
            for(int s=1; s<=size; s++) {
                int v = sum[s+i-1] - sum[s-1];
                if(v > target) continue;
                arr[v]++;
            }
        }
        if(sum[size] <= target) arr[sum[size]]++;
    }
}
