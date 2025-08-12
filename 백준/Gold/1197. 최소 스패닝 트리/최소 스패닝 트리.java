import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int len;
    public Edge(int from, int to, int len) {
        this.from = from;
        this.to = to;
        this.len = len;
    }
    @Override
    public int compareTo(Edge e) {
        return this.len - e.len;
    }
}
public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        p = new int[V+1];
        for(int i=1; i<=V; i++) {
            p[i] = -1;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(A, B, C));
        }

        int edgeNum = 0;
        int len = 0;
        while(true) {
            if(edgeNum == V-1) {
                break;
            }
            Edge edge = pq.poll();
            int ra = find(edge.from);
            int rb = find(edge.to);
            if(ra != rb) {
                union(ra, rb);
                len += edge.len;
                edgeNum++;
            }
        }
        System.out.println(len);
    }
    static int find(int x) {
        if(p[x] == -1) {
            return x;
        }
        return p[x] = find(p[x]);
    }
    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x==y) {
            return false;
        }
        p[x] = y;
        return true;
    }

}
