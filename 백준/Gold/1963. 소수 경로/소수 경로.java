import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime = new boolean[10000];
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // 에라토스테네스의 체. false인 애들이 소수임
        prime[0] = true;
        prime[1] = true;
        for(int i=2; i*i<100000000; i++) {
            if(prime[i]) {
                continue;
            }
            for(int j=i*i; j<10000; j += i) {
                prime[j] = true;
            }
        }

        for(int tc=0; tc<TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int result = bfs(src, target);
            if(result == -1) {
                sb.append("Impossible").append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
    static int bfs(int src, int target) {
        visited = new boolean[10000];
        int[] dist = new int[10000];
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.offer(src);
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == target) {
                return dist[curr];
            }

            /*
            현재 숫자 -> 스트링 -> char형 배열로 해서 한 글자씩 0~9로 변경
             */
            String currStr = Integer.toString(curr);
            char[] arr = currStr.toCharArray();
            for(int i=0; i<4; i++) { // i가 0이면 천의 자리 숫자
                char c = arr[i]; // 천, 백, 십, 일의 자리에 원래 있던 숫자

                for(int n=0; n<=9; n++) {
                    // 천의 자리 숫자를 0으로 변경하면 안 되므로 넘어감
                    if(n==0 && i==0) {
                        continue;
                    }
                    // 바꾸려는 숫자가 현재 숫자와 같으면 넘어감
                    if(n==(c-'0')) {
                        continue;
                    }
                    arr[i] = (char) (n+'0');
                    int candidate = Integer.parseInt(new String(arr));
                    if(!visited[candidate] && !prime[candidate]) {
                        visited[candidate] = true;
                        dist[candidate] = dist[curr]+1;
                        q.offer(candidate);
                    }
                }
                arr[i] = c;
            }
        }
        return -1;
    }
}
