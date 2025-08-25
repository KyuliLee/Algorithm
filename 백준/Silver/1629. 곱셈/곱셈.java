import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(cal(A, B));

    }
    static long cal(int a, int e) {
        if(e==1) {
            return a%C;
        }
        long temp = (cal(a, e/2)%C);
        temp = (temp*temp)%C;

        if(e%2 == 1) {
            temp = (temp*a)%C;
        }
        return temp;
    }
}
        /*
        이렇게 하면 시간 초과. B가 21억이면 10억 번이 거의 1초이기 때문에.
         */
//        int mul = A%C;
//        int ans = mul;
//        for(int b=0; b<B; b++) {
//            ans *= mul;
//            ans %= C;
//        }
//        System.out.println(ans);
