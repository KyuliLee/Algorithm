import java.io.*;
import java.util.*;

public class Main {
    static int target, m, n;
    static int[] circleA, circleB, sumA, sumB, cntA, cntB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        circleA = new int[2*m];
        circleB = new int[2*n];
        for (int i = 0; i < m; i++) { circleA[i] = Integer.parseInt(br.readLine()); circleA[m+i] = circleA[i]; }
        for (int i = 0; i < n; i++) { circleB[i] = Integer.parseInt(br.readLine()); circleB[n+i] = circleB[i]; }

        // prefix sums: sum[0]=0; sum[i]=sum[i-1]+arr[i-1]
        sumA = new int[2*m + 1];
        for (int i = 1; i <= 2*m; i++) sumA[i] = sumA[i-1] + circleA[i-1];

        sumB = new int[2*n + 1];
        for (int i = 1; i <= 2*n; i++) sumB[i] = sumB[i-1] + circleB[i-1];

        cntA = new int[target + 1];
        cntB = new int[target + 1];
        makeArr(cntA, sumA, m, target);
        makeArr(cntB, sumB, n, target);

        long ans = 0;
        ans += cntA[target];         // A만
        ans += cntB[target];         // B만
        for (int x = 1; x < target; x++) ans += (long) cntA[x] * cntB[target - x]; // A+B
        System.out.println(ans);
    }

    // arr[v] = 해당 피자 하나로 합 v 만드는 방법 수
    static void makeArr(int[] arr, int[] sum, int size, int target) {
        // 길이 1..size-1, 시작 s=0..size-1
        for (int len = 1; len <= size - 1; len++) {
            for (int s = 0; s <= size - 1; s++) {
                int v = sum[s + len] - sum[s];
                if (v <= target) arr[v]++;
            }
        }
        // 전체 원판(길이=size)은 한 번만
        int whole = sum[size] - sum[0]; // = sum[size]
        if (whole <= target) arr[whole]++;
    }
}
