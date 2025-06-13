import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int treeNum;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean isTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 0;
        StringBuilder sb = new StringBuilder();

        while(true) {
            T++;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0) {
                break;
            }

            graph = new ArrayList[n+1];
            for(int i=1; i<n+1; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            } // 초기화 완료

            treeNum = 0;
            visited = new boolean[n+1];
            isTree = true;
            for(int i=1; i<n+1; i++) {
                if(!visited[i]) {
                    // 처음 시작하는 점은 부모가 없으니까 -1로 해버리면 됨
                    dfs(i, -1);
                    if(isTree) {
                        treeNum++;
                    } else {
                        isTree = true;
                    }
                }
            }
            if(treeNum == 0) {
                sb.append("Case ").append(T).append(": No trees.").append("\n");
            } else if(treeNum == 1) {
                sb.append("Case ").append(T).append(": There is one tree.").append("\n");
            } else {
                sb.append("Case ").append(T).append(": A forest of ").append(treeNum).append(" trees.").append("\n");
            }
        }

        System.out.print(sb);

    }
    public static void dfs(int start, int parent) {
        visited[start] = true;
        ArrayList<Integer> list = graph[start];
        for(int node : list) {
            if(!visited[node]) {
                dfs(node, start);
            } else if(visited[node] && node!=parent) {
                isTree = false;
            }
        }
    }
}
