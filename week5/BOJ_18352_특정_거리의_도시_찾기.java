package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_특정_거리의_도시_찾기 {

	private static ArrayList<Integer>[] arr;
	private static int[] length;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
		}
		
		length = new int[N+1];
		Arrays.fill(length, -1);
		
		bfs(X);
		
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			if(length[i] == K) {
				answer.add(i);
			}
		}
		if(answer.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(answer);
			for(int i=0; i<answer.size(); i++) {
				System.out.println(answer.get(i));
			}
		}
		
	}
	static void bfs(int s) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		length[s] = 0; // 시작 도시의 거리는 0이라고 하자.
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i=0; i<arr[current].size(); i++) {
				int next = arr[current].get(i);
				if(length[next] == -1) {
					length[next] = length[current] + 1;
					queue.add(next);
				}
			}
			
		}
		
	}
}
