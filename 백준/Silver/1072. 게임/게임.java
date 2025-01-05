import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
//        if(X==Y) {
//            System.out.println(-1);
//            return;
//        }
        long currZ = Y*100/X;
        if(currZ >= 99) {
            System.out.println(-1);
            return;
        }

        long low = 1; // 게임을 최소한 1번은 해봐야 한다.
        long high = X;

        while(low < high) {
            long mid = (low+high)/2;

            long newZ = (Y+mid)*100/(X+mid);
//            System.out.println("currZ : " + currZ + ", newZ : " + newZ);
            if(newZ == currZ) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }
}