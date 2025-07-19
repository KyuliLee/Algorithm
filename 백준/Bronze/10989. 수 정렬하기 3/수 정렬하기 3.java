import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10000001]; // 해당 index에 숫자가 몇 개인지 저장하는 배열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000000; i++) {
            while(arr[i] != 0) {
                sb.append(i).append("\n");
                arr[i]--;
            }
        }
        System.out.print(sb);
    }
}
