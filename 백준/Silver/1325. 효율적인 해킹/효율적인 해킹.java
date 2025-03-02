import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] cnt;
    static int max = 0;
    static int startNum;
    static int thisCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        cnt = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list[s].add(e);
        } // 초기화 완료

        // list를 다 돌면서 dfs. 가장 많은 컴퓨터를 해킹해야 하므로.
        for(int i=1; i<=N; i++) {
            startNum = i;
            thisCnt = 0;
            visit = new boolean[N+1];
            dfs(i);
            cnt[i] = thisCnt;
            if(thisCnt > max) {
                max = thisCnt;
            }
        }

        // max 찾기
        for(int n : cnt) {
            if(n > max) max = n;
        }

        // max값을 갖는 cnt의 인덱스 찾기
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(cnt[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
    static void dfs(int s) {
        // 해당 컴퓨터 방문 체크
        visit[s] = true;
        ArrayList<Integer> temp = list[s];
        // 그 컴퓨터의 리스트를 돌면서 dfs
        for(int n : temp) {
            if(visit[n]) {
                continue;
            }
            thisCnt++;
            dfs(n);
        }

    }
}
/*
1 -> 3
2 -> 3
3 -> 4
3 -> 5
ArrayList로 이 관계를 다 저장

 */