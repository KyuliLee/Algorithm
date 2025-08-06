import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            if(n==1) {
                sb.append(1).append("\n");
                continue;
            }
            if(n==2) {
                sb.append(2).append("\n");
                continue;
            }
            if(n==3) {
                sb.append(4).append("\n");
                continue;
            }
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            for(int i=4; i<=n; i++) {
                arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
            }
            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }
}
