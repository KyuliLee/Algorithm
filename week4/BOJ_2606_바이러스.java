package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

	private static boolean[] visited;
	private static ArrayList<Integer>[] list;
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for(int i=1; i<=pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		DFS(1);
//		BFS(1);
		System.out.println(cnt);
		
	}
	
	static void DFS(int num) {
		visited[num] = true;
		
		for(int i=0; i<list[num].size(); i++) {
			int e = list[num].get(i);
			if(!visited[e]) {
				cnt++;
				DFS(e);
			}
		}
		
	}
//	
//	static void BFS(int num) {
//		visited[num] = true;
//		Queue<Integer> queue = new LinkedList<>();
//		queue.offer(num);
//		
//		while(!queue.isEmpty()) {
//			int v = queue.poll();
//			for(int i=0; i<list[v].size(); i++) {
//				int e = list[v].get(i);
//				if(!visited[e]) {
//					queue.offer(e);
//					cnt++;
//					visited[e] = true;
//				}
//			}
//			
//		}
//	}

}