import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int[] arr;
    static ArrayList<Integer>[] list = new ArrayList[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        // inorder 순서대로 방문했음
        int end = (int)Math.pow(2, K)-1; // K가 3이라면 end는 7
        arr = new int[end];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<end; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=10; i++) {
            list[i] = new ArrayList<>();
        }

        func(0, end-1, 1);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=K; i++) {
            for(int n : list[i]) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void func(int s, int e, int level) {
        if(s>e) return; // 있을 수 없는 경우
        if(s==e) {
            list[level].add(arr[s]);
            return;
        }
        int mid = (s+e)/2;
        list[level].add(arr[mid]);
        func(s, mid-1, level+1);
        func(mid+1, e, level+1);
    }
}
