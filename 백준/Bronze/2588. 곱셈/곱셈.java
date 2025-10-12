import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = n1*(n2%10);
        int n4 = n1*((n2/10)%10);
        int n5 = n1*(n2/100);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n5*100+n4*10+n3);

    }
}
