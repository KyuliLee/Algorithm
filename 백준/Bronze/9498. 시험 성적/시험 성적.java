import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n>=90) System.out.println("A");
        else if(n>=80) System.out.println("B");
        else if(n>=70) System.out.println("C");
        else if(n>=60) System.out.println("D");
        else System.out.println("F");
    }
}
