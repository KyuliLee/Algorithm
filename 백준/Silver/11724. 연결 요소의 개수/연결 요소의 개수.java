
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int n;
	private static int m;
	private static StringBuilder sb = new StringBuilder();
	private static boolean[] visited;
	private static List<Integer>[] edges;
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		int cc = 0;
		
		edges = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			edges[s].add(e);
			edges[e].add(s);
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				DFS(i);
				cc++;
			}
		}
		System.out.println(cc);
	}
	
	public static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int i : edges[v]) {
			DFS(i);
		}
	}
}