import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        /*
        9개의 숫자 중 7개를 더해 합이 100이 되어야 함.
        9개의 합은 sum, 숫자 2개를 빼서 100이 되게 하는 두 숫자를 구하자.
         */
        Arrays.sort(arr);
        int a = -1;
        int b = -1;
        boolean flag = false;
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum-arr[i]-arr[j] == 100) {
                    a = i;
                    b = j;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<9; i++) {
            if(i != a && i != b) {
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.print(sb);

    }
}