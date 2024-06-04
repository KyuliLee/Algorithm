package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
	
	private static int N;
	private static int M;
	private static boolean[] visited;
	private static int answer = 0;
	private static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		for(int i=0; i<N; i++) {
			if(answer == 0) {
				DFS(i, 1);
			} else {
				break;
			}
		}
		System.out.println(answer);
		
	}
	
	static void DFS(int start, int depth) {
		if(depth == 5) {
			answer = 1;
			return;
		}
		
		visited[start] = true;
		
		for(int i=0; i<list[start].size(); i++) {
			int next = list[start].get(i);
			if(!visited[next]) {
				DFS(next, depth + 1);
			}
		}
		visited[start] = false;
	}

}
