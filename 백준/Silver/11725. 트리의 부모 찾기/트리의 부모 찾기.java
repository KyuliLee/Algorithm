import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        /*
        1부터 시작해서 graph[i]인 list 확인.
        parent[] 에 i의 부모 저장
        list의 요소들은 i와 연결된 부모/자식인데 bfs로 부모부터 내려왔으니까 아직 parent[i]가 갱신이 안 됐다면 갱신
         */
        int[] parent = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()) {
            int elem = q.poll();
            ArrayList<Integer> list = graph[elem];
            for(int n : list) {
                if(parent[n] == 0) {
                    parent[n] = elem;
                    q.offer(n);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}
