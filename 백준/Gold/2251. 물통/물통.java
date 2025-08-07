import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bucket {
    int a;
    int b;
    int c;
    public Bucket(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class Main {
    static Set<Integer> set = new TreeSet<>();
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bfs();
        StringBuilder sb = new StringBuilder();
        for(int n : set) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
    static void bfs() {
        Queue<Bucket> q = new LinkedList<>();
        q.offer(new Bucket(0, 0, C));
        boolean[][][] visited = new boolean[A+1][B+1][C+1];
        while(!q.isEmpty()) {
            Bucket bucket = q.poll();
            int a = bucket.a;
            int b = bucket.b;
            int c = bucket.c;

            if(visited[a][b][c]) {
                continue;
            }
            visited[a][b][c] = true;
            if(a==0) {
                set.add(c);
            }

            // c->a
            if(a+c <= A) {
                q.offer(new Bucket(a+c, b, 0));
            } else {
                q.offer(new Bucket(A, b, a+c-A));
            }
            // c->b
            if(b+c <= B) {
                q.offer(new Bucket(a, b+c, 0));
            } else {
                q.offer(new Bucket(a, B, b+c-B));
            }
            // a->b
            if(a+b <= B) {
                q.offer(new Bucket(0, a+b, c));
            } else {
                q.offer(new Bucket(a+b-B, B, c));
            }
            // a->c
            if(a+c <= C) {
                q.offer(new Bucket(0, b, a+c));
            } else {
                q.offer(new Bucket(a+c-C, b, C));
            }
            // b->c
            if(b+c <= C) {
                q.offer(new Bucket(a, 0, b+c));
            } else {
                q.offer(new Bucket(a, b+c-C, C));
            }
            // b->a
            if(b+a <= A) {
                q.offer(new Bucket(a+b, 0, c));
            } else {
                q.offer(new Bucket(A, a+b-A, c));
            }
        }
    }
}
