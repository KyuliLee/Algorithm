	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class Main {
	
		private static ArrayList<Edge>[] list; // Edge 객체를 요소로 갖는 ArrayList를 저장하는 배열
		private static int[] dist;
		private static boolean[] visited;
		
		static class Edge {
			int e;
			int w;
			
			public Edge(int e, int w) {
				this.e = e;
				this.w = w;
			}
		}
		
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int V = Integer.parseInt(br.readLine());
			
			// list 초기화
			list = new ArrayList[V+1]; // 정점 번호가 1부터 시작하므로 크기가 V+1인 배열 생성
			for(int i=1; i<=V; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=1; i<=V; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				while(true) {
					int e = Integer.parseInt(st.nextToken());
					if(e == -1)
						break;
					int w = Integer.parseInt(st.nextToken());
					list[s].add(new Edge(e, w));
				}
			}
			
			dist = new int[V+1];
			visited = new boolean[V+1];
			
			/*
			 *  트리는 방향이 없고 사이클을 갖지 않는다. 따라서 임의의 두 정점의 경로는 단 하나만 존재한다.
			 *  따라서, 한 정점에서 가장 먼 정점으로 가는 경로와 트리의 지름은 겹치는 부분이 있을 수밖에 없다.
			 *  트리의 지름을 찾기 위해서는 2번의 탐색만이 필요하다.
			 *  
			 *  1번 정점에서 가장 먼 정점을 구하자. 1번 정점이 아닌 어떤 정점이어도 상관 없다.
			 *  그 가장 먼 정점에서 다른 정점까지의 거리의 최댓값을 출력.
			 */
			 
			BFS(1);
			int max = 0;
			for(int i=1; i<=V; i++) {
				if(dist[max] < dist[i])
					max = i;
				
			}
			
			// 한 정점에서 다른 정점까지의 거리를 나타내는 배열 dist, 방문 여부를 나타내는 배열 visited 초기화
			dist = new int[V+1];
			visited = new boolean[V+1];
			BFS(max);
			 
			Arrays.sort(dist);
			System.out.println(dist[V]);
			
		}
		
		// 매개변수로 주어진 노드와 연결된 노드들을 모두 방문하고 거리를 업데이트한다.
		static void BFS(int node) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(node);
			visited[node] = true;
			while(!queue.isEmpty()) {
				int now = queue.poll();
				for(int i=0; i<list[now].size(); i++) {
					Edge edge = list[now].get(i);
					int end = edge.e;
					if(!visited[end]) {
						visited[end] = true;
						queue.add(end);
						dist[end] = dist[now] + edge.w;
					}
				}
			}
			
		}
	
	}
