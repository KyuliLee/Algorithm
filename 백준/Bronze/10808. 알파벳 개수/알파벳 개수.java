import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int idx = c-97;
            arr[idx]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);

    }
}