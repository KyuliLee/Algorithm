import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] arr = new int[L];
        for(int i=0; i<L; i++) {
            arr[i] = str.charAt(i)-96;
        }
        long ans = 0;
        long mul = 1;
        for(int i=0; i<L; i++) {
            ans += (arr[i]*mul)%1234567891;
            mul = (mul*31)%1234567891;
        }
        System.out.println(ans%1234567891);
    }
}
