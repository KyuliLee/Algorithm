import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Number {
    int n;
    long cmd;
    public Number(int n, long cmd) {
        this.n = n;
        this.cmd = cmd;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            long resL = bfs(src, target);
            // D, S, L, R을 각각 1, 2, 3, 4로 하는 long을 가져옴. 이걸 D, S, L, R로 고쳐야 함
            String res = getResult(resL);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
    static String getResult(long n) {
        String ans = "";
        while(n!=0) {
            int k = (int) (n%10);
            if(k==1) {
                ans = "D"+ans;
            } else if(k==2) {
                ans = "S"+ans;
            } else if(k==3) {
                ans = "L"+ans;
            } else {
                ans = "R"+ans;
            }
            n /= 10;
        }
        return ans;
    }
    static long bfs(int src, int target) {
        Queue<Number> q = new LinkedList<>();
        q.offer(new Number(src, 0));
        boolean[] visited = new boolean[10000];
        visited[src] = true;

        while(!q.isEmpty()) {
            Number curr = q.poll();
            if(curr.n == target) {
                return curr.cmd;
            }

            // D
            int newN = (curr.n*2)%10000;
            if(!visited[newN]) {
                q.offer(new Number(newN, curr.cmd*10 + 1));
                visited[newN] = true;
            }

            // S
            if(curr.n == 0) {
                newN = 9999;
            } else {
                newN = curr.n-1;
            }
            if(!visited[newN]) {
                q.offer(new Number(newN, curr.cmd*10 + 2));
                visited[newN] = true;
            }

            // L
            int d1 = curr.n/1000;
            int d2 = (curr.n%1000)/100;
            int d3 = (curr.n%100)/10;
            int d4 = curr.n%10;
            newN = d2*1000 + d3*100 + d4*10 + d1;
            if(!visited[newN]) {
                q.offer(new Number(newN, curr.cmd*10 + 3));
                visited[newN] = true;
            }

            // R
            newN = d4*1000 + d1*100 + d2*10 + d3;
            if(!visited[newN]) {
                q.offer(new Number(newN, curr.cmd*10 + 4));
                visited[newN] = true;
            }

        }
        return -1;
    }
}
