import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, sortedArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sortedArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(sortedArr[0], cnt++);
        for(int i=1; i<N; i++) {
            if(sortedArr[i] == sortedArr[i-1]) {
                continue;
            }
            map.put(sortedArr[i], cnt++);
        }

        for(int i=0; i<N; i++) {
            int n = map.get(arr[i]);
            sb.append(n).append(" ");
        }

        System.out.println(sb);

    }

}
