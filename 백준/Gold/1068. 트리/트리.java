import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, deleteNode;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for(int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
        }
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n==-1) {
                root = i;
                continue;
            }
            tree[n].add(i);
        }
        deleteNode = Integer.parseInt(br.readLine());
        if(deleteNode == root) {
            System.out.println(0);
            return;
        }
        int ans = dfs(root);
        System.out.println(ans);
    }
    static int dfs(int curr) {
        int ret = 0;
        int child = 0;
        for(int next : tree[curr]) {
            if(next == deleteNode) continue;
            ret += dfs(next);
            child++;
        }
        if(child == 0) return 1;
        return ret;
    }
}
