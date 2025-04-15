import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            ans = new int[6];
            st= new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k==0) {
                break;
            }
            arr = new int[k];
            for(int i=0; i<k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            } // 초기화 완료
            func(0, 0);

            sb.append("\n");
        }
        System.out.println(sb);


    }
    static void func(int idx, int depth) {
        if(depth == 6) {
            for(int n : ans) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=idx; i<k; i++) {
            ans[depth] = arr[i];
            func(i+1, depth+1);
        }
    }
}
