import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] pop;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE; // 최소 인구 차이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pop = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pop[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                graph[i].add(neighbor);
                graph[neighbor].add(i);
            }
        }

        // 구역을 나누는 모든 경우를 탐색
        for (int r = 1; r <= N / 2; r++) {
            comb(new ArrayList<>(), 1, r);
        }

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    // 조합을 생성하는 메서드
    static void comb(List<Integer> areaA, int start, int r) {
        if (areaA.size() == r) {
            List<Integer> areaB = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!areaA.contains(i)) areaB.add(i);
            }

            if (isConnected(areaA) && isConnected(areaB)) {
                calcDiff(areaA, areaB);
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            areaA.add(i);
            comb(areaA, i + 1, r);
            areaA.remove(areaA.size() - 1);
        }
    }

    // 구역이 연결되어 있는지 확인
    static boolean isConnected(List<Integer> area) {
        visited = new boolean[N + 1];
        dfs(area.get(0), area);

        for (int node : area) {
            if (!visited[node]) return false; // 연결되지 않은 노드가 있으면 false
        }
        return true;
    }

    // 깊이 우선 탐색으로 구역을 탐색
    static void dfs(int node, List<Integer> area) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor] && area.contains(neighbor)) {
                dfs(neighbor, area);
            }
        }
    }

    // 두 구역 간 인구 차이를 계산
    static void calcDiff(List<Integer> areaA, List<Integer> areaB) {
        int popA = 0, popB = 0;
        for (int node : areaA) popA += pop[node];
        for (int node : areaB) popB += pop[node];

        minDiff = Math.min(minDiff, Math.abs(popA - popB));
    }
}