import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] numOfChild;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        numOfChild = new int[N+1]; // 해당 노드를 포함해 자식 노드가 몇 개가 있는지 저장
        for(int i=1; i<=N; i++) {
            numOfChild[i] = 1;
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        traversal(R, -1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(numOfChild[n]).append("\n");
        }
        System.out.print(sb);

    }
    static void traversal(int node, int parent) {
        for(int elem : tree[node]) {
            if(elem == parent) continue;
            traversal(elem, node);
        }
        if(parent != -1) {
            numOfChild[parent] += numOfChild[node];
        }
    }
}
