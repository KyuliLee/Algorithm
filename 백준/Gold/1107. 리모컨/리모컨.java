import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 100) {
            System.out.println(0);
            return;
        }

        int M = Integer.parseInt(br.readLine());
        boolean[] isBroken = new boolean[10];
        if(M == 0) {
            if(N>=98 && N<=103) {
                System.out.println(Math.abs(N-100));
                return;
            }
        } else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                int n = Integer.parseInt(st.nextToken());
                isBroken[n] = true;
            } // 초기화 완료
        }

        /*
        최악의 경우, 만약 N이 500,000이고 9번 버튼만 멀쩡하다면 999,999에서 -버튼으로 하나씩 내려와야 하므로 이 경우까지 고려
        초기값은 100에서 +, - 버튼으로 이동하는 값으로 둔다.
        0부터 999,999를 눌렀다는 가정 하에 N까지 이동하는 경우와 초기값을 비교해서 더 작은 값으로 변경
        예를 들면, N이 10일 때 100에서 +, - 버튼만 눌렀을 때 초기값은 90번
            1을 누르고(1번) + 1-10의 절댓값(9번)을 더하면 10번이 되므로 초기값을 10으로 갱신
            2를 누르고(1번) + 2-10의 절댓값(8번)을 더하면 9번이 되므로 초기값을 9로 갱신
            ...
            10을 누르고(2번) + 10-10의 절댓값(0번)을 더하면 2번이 되므로 초기값을 2로 갱신
            11, 12, ..., 999,999까지 다 비교.
         */
        int best = Math.abs(100-N);
        for(int i=0; i<=9999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean hasBrokenNumber = false;
            for(int j=0; j<len; j++) {
                int n = str.charAt(j)-'0';
                if(isBroken[n]) {
                    hasBrokenNumber = true;
                    break;
                }
            }
            if(hasBrokenNumber) { continue; }

            int temp = len + Math.abs(i-N);
            best = Math.min(best, temp);
        }
        System.out.println(best);


    }
}
