import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(Math.pow(31,50));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] arr = new int[L];
        for(int i=0; i<L; i++) {
            arr[i] = str.charAt(i)-96;
        }
        int ans = 0;
        for(int i=0; i<L; i++) {
            ans += arr[i]*(int)Math.pow(31, i);
        }
        System.out.println(ans);
    }
}
