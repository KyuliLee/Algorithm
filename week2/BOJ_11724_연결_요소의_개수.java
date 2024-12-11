//package week2;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BOJ_11724_연결_요소의_개수 {
//
//	private static ArrayList<Integer>[] A;
//	private static boolean[] visited;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		A = new ArrayList[N+1];
//		visited = new boolean[N+1];
//		int cnt = 0;
//
//		// 인접리스트 초기화
//
//		for(int i=1; i<N+1; i++) {
//			A[i] = new ArrayList<Integer>();
//		}
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int s = Integer.parseInt(st.nextToken());
//			int e = Integer.parseInt(st.nextToken());
//			A[s].add(e);
//			A[e].add(s);
//		}
//
//		for(int i=1; i<N+1; i++) {
//			if(!visited[i]) {
//				cnt++;
//				DFS(i);
//			}
//		}
//
//		System.out.println(cnt);
//
//
//	}
//
//	static void DFS(int v) {
//		if(visited[v]) {
//			return;
//		}
//
//		visited[v] = true;
//
//		for(int i : A[v]) {
//			if(!visited[i]) {
//				DFS(i);
//			}
//		}
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
