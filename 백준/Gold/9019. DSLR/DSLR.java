import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int n;
    String str;
    public Node(int n, String str) {
        this.n = n;
        this.str = str;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        // A를 B로 변환하는 최소한의 명령어를 나열하기
        // Node타입의 큐를 넣고 B가 될 때까지 넣었다 뺐다 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Node nodeA = new Node(A, "");
            Queue<Node> q = new LinkedList<>();
            q.offer(nodeA);
            // 임의의 숫자 num에 대해서 계산했는데 중간 연산의 결과로 num이 나올 경우에 또 계산하는 것을 방지
            boolean[] visited = new boolean[10000];
            visited[A] = true;
            while(!q.isEmpty()) {
                // now의 숫자가 B와 같으면 출력하고 리턴
                Node now = q.poll();
                if(now.n == B) {
                    System.out.println(now.str);
                    break;
                }
                // D, S, L, R을 연산한 결과값과 str에 명령어 추가한 걸로 노드 만들고 큐에 넣음
                int d = calD(now.n);
                if(!visited[d]) {
                    visited[d] = true;
                    q.offer(new Node(d, now.str+"D"));
                }
                int s = calS(now.n);
                if(!visited[s]) {
                    visited[s] = true;
                    q.offer(new Node(s, now.str+"S"));
                }
                int l = calL(now.n);
                if(!visited[l]) {
                    visited[l] = true;
                    q.offer(new Node(l, now.str+"L"));
                }
                int r = calR(now.n);
                if(!visited[r]) {
                    visited[r] = true;
                    q.offer(new Node(r, now.str+"R"));
                }
            }
        }
    }
    public static int calD(int n) {
        int res = n*2;
        if(res > 9999) {
            return res % 10000;
        }
        return res;
    }
    public static int calS(int n) {
        int res = n-1;
        if(n == 0) {
            return 9999;
        }
        return res;
    }
    public static int calL(int n) { // n이 1234
        int d4 = n%10;
        n /= 10; // n이 123
        int d3 = n%10;
        n /= 10; // n이 12
        int d2 = n%10;
        n /= 10; // n이 1
        int d1 = n;

        return d2*1000 + d3*100 + d4*10 + d1;
    }
    public static int calR(int n) { // n이 1234
        int d4 = n%10;
        n /= 10; // n이 123
        int d3 = n%10;
        n /= 10; // n이 12
        int d2 = n%10;
        n /= 10; // n이 1
        int d1 = n;

        return d4*1000 + d1*100 + d2*10 + d3;
    }
}