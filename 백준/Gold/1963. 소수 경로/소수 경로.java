import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime = new boolean[10000]; // 값이 false인 인덱스가 소수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 에라토스테네스의 체
        for(int i=2; i*i<10000; i++) {
            if(prime[i]) {
                continue;
            }
            for(int j=i*i; j<10000; j += i) {
                prime[j] = true;
            }
        }
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int res = bfs(src, target);
            if(res == -1) {
                sb.append("Impossible").append("\n");
            } else {
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);
    }
    static int bfs(int src, int target) {
        boolean[] visited = new boolean[10000];
        visited[src] = true;
        int[] cnt = new int[10000];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        /*
        원래 숫자 -> 스트링 -> char 배열로 바꾸고 천, 백, 십, 일의 자리 숫자를 하나씩 0~9로 바꾸기
        바꾼 char 배열 -> 스트링 -> 숫자로 바꿔서 prime인지 확인
        cnt배열 값 갱신하고 만약 target과 같으면 그 때 cnt값 리턴
         */
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == target) {
                return cnt[curr];
            }
            char[] charArr = String.valueOf(curr).toCharArray();

            for(int i=0; i<4; i++) {
                char c = charArr[i]; // 바꿀 숫자
                for(int n=0; n<=9; n++) {
                    // 천의 자리 숫자가 0이면 안 되므로 넘어감
                    if(n==0 && i==0) {
                        continue;
                    }
                    // 바꾸려는 숫자가 현재 숫자와 같으면 넘어감
                    if(n == (c-'0')) {
                        continue;
                    }
                    charArr[i] = (char) (n+'0');
                    int candidate = Integer.parseInt(new String(charArr));
                    if(!visited[candidate] && !prime[candidate]) {
                        visited[candidate] = true;
                        cnt[candidate] = cnt[curr]+1;
                        q.offer(candidate);
                    }
                }
                charArr[i] = c;
            }
        }

        return -1;
    }
}
