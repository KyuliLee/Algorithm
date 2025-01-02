import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] T;
    static int[] P;
    static int[] best;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        best = new int[N+2];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        } // 초기화 완료
        int max = 0;
        for(int i=1; i<=N; i++) {
            best[i] = Math.max(best[i], best[i-1]);
            if(i+T[i]<=N+1) {
                best[i+T[i]] = Math.max(best[i]+P[i], best[i+T[i]]);
            }
        }
        best[N+1] = Math.max(best[N], best[N+1]);
        System.out.println(best[N+1]);
//        System.out.println(Arrays.stream(best).max().getAsInt());
//        System.out.println(Arrays.toString(best));
    }
}