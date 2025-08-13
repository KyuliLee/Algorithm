import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr, ans;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int vowelNum = 0;
    static int consonantNum = 0;
    static Set<Character> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = new char[L];
        arr = new char[C];
        visited = new boolean[C];

        PriorityQueue<Character> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            char c = st.nextToken().charAt(0);
            pq.offer(c);
        }
        for(int i=0; i<C; i++) {
            arr[i] = pq.poll();
        }
        set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        dfs(0, 0);
        System.out.println(sb);

    }
    static void dfs(int start, int depth) {
        if(depth == L) {
            if(vowelNum>=1 && consonantNum>=2) {
                for(int i=0; i<L; i++) {
                    sb.append(ans[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i=start; i<C; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            ans[depth] = 'k';

            ans[depth] = arr[i];
            if(set.contains(arr[i])) {
                vowelNum++;
            } else {
                consonantNum++;
            }
            dfs(i, depth+1);
            visited[i] = false;
            if(set.contains(arr[i])) {
                vowelNum--;
            } else {
                consonantNum--;
            }
        }
    }
}
