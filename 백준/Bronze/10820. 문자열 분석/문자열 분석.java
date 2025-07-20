import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null) {
            int small = 0;
            int big = 0;
            int num = 0;
            int blank = 0;
            for(int i=0; i<str.length(); i++) {
                int n = str.charAt(i)-'0';
                if(n>=17 && n<=42) {
                    big++;
                } else if(n>=49 && n<=74) {
                    small++;
                } else if(n==-16) {
                    blank++;
                } else {
                    num++;
                }
            }
            sb.append(small).append(" ").append(big).append(" ").append(num).append(" ").append(blank).append("\n");
        }
        System.out.println(sb);
    }
}