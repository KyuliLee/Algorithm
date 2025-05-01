import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int pos;
    int cnt;
    public Node(int pos, int cnt) {
        this.pos = pos;
        this.cnt = cnt;
    }
}
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리 갯수. 사다리는 내려감
        int M = Integer.parseInt(st.nextToken()); // 뱀 갯수. 뱀은 올라감

        int[] arr = new int[101];
        boolean[] visited = new boolean[101];

        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start] = end;
        } // 이동할 칸 저장

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        visited[1] = true;

        while(!q.isEmpty()) {
            Node curr = q.poll();

            if(curr.pos == 100) {
                System.out.println(curr.cnt);
                break;
            }
            for(int i=1; i<=6; i++) {
                int newPos = curr.pos + i;
                if(newPos > 100) {
                    continue;
                }
                if(arr[newPos] != 0) {
                    newPos = arr[newPos];
                }
                if (!visited[newPos]) {
                    visited[newPos] = true;
                    q.offer(new Node(newPos, curr.cnt + 1));
                }

            }
        }

    }
}
