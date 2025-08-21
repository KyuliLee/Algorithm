import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while(str != null || str == "") {
            int N = Integer.parseInt(str);
            /*
            1, 11, 111, 1...1 이 N으로 나눠 떨어질 때 1이 몇 개 있는지 찾기
            1.....1 이 long보다 커질 수 있으니 나머지 연산 이용
            ex) n이 3인 경우
            1 % 3 = 1
            11 % 3 = (10+1) % 3 = (10%3) + (1%3) = 1 + 1 = 2
            111 % 3 = (10*11+1) % 3 = ((10%3)*(11*3) + 1%3) % 3 = (1*2 + 1) % 3 = 0

             */
            int one = 1;
            int cnt = 1;
            while(true) {
                if(one % N == 0) {
                    System.out.println(cnt);
                    break;
                }

                one = (one*10+1)%N;

                cnt++;
            }
            str = br.readLine();

        }


    }
}
