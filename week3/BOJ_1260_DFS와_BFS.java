package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와_BFS {

	private static int N;
	private static int M;
	private static int start;
	private static boolean[] visited;
	private static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		
		DFS(start);
		
		System.out.println();
		Arrays.fill(visited, false);
		
		BFS(start);
	}
	
	static void DFS(int start) {
		System.out.print(start + " ");
		visited[start] = true;
		for(int i=0; i<list[start].size(); i++) {
			int next = list[start].get(i);
			if(!visited[next]) DFS(next);
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for(int i=0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}

}
