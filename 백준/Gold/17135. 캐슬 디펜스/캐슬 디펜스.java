import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D;
    static int[][] arr, enemies; // arr는 원본 배열. 수정하지 않음. enemies는 한 턴이 지날 때마다 적 위치 업데이트하는 배열
    static int[] archer;
    static boolean[][] visited; // 궁수가 공격한 최단거리 적 위치를 저장하기 위한 배열
    static boolean[] archerVisited; // 궁수 3명 위치 구하기 위한 방문 배열
    static int max = Integer.MIN_VALUE; // 죽일 수 있는 적의 최대 숫자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        enemies = new int[N][M];
        visited = new boolean[N][M];
        archerVisited = new boolean[M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        archer = new int[3];
        // 초기화 완료

        /*
        궁수 3명의 위치에서 최대로 잡을 수 있는 적의 수 구하기
        1. 조합으로 0~M-1 중 3개를 뽑아서 archer 배열에 넣음. 3개 다 뽑을 때마다 2~5 반복
        2. 궁수 3개의 위치로 적 잡기.
           arr와 동일하게 enemies배열 초기화, 잡은 적의 위치를 기록하기 위한 visited배열 초기화
           3개 값을 for문으로 반복. 그 때마다 최단거리 값, 위치 초기화.
           [0][0] ~ [N-1][M-1] 에서 1이면 그 때 궁수의 위치와 거리가 D이하이면
              임시 최단거리 값보다 더 작은 위치가 나오면 임시 최단거리 값, 위치 갱신
              임시 최단거리 값과 동일한 값이 나온다면 더 왼쪽에 있는 값으로 위치 갱신
           끝까지 돌았을 때 visited배열에서 최단거리의 적의 위치를 true로 갱신
        3. 궁수 3명의 위치에서 격자판을 모두 다 돌았다면 visited배열을 돌면서 true인 것 개수 셈.
           (최단거리에 있는 적을 찾자마자 카운트하지 않는 이유는 그 위치의 적이 2명 이상의 궁수에게 최단거리일 수 있고 같은 적이 여러 궁수에게
           공격받을 수 있어서 여러 번 카운트하지 않기 위해서)
        4. 적들을 한 칸씩 앞으로 땡김
        5. 2~4를 N번 반복
         */

        comb(0, 0);
        System.out.println(max);


    }
    static void comb(int start, int depth) {
        if(depth == 3) {
            init();
            int totalKilledEnemyNum = 0;
            for(int n=0; n<N; n++) { // 한 턴마다 3명의 궁수가 적 공격
                visited = new boolean[N][M];
                for(int i=0; i<3; i++) {
                    findClosestEnemy(archer[i]);
                }
                totalKilledEnemyNum += killEnemyAndCount();
                updateEnemyPos(n);
            }
            if(totalKilledEnemyNum > max) {
                max = totalKilledEnemyNum;
            }
//            max = Math.max(max, totalKilledEnemyNum);

            return;
        }


        for(int i=start; i<M; i++) {
            if(archerVisited[i]) { continue; }
            archerVisited[i] = true;
            archer[depth] = i;
            comb(i+1, depth+1);
            archerVisited[i] = false;
        }
    }
    static void findClosestEnemy(int archerColumn) {
        int minD = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(enemies[i][j] == 0) { continue; }
                int dist = getDistance(i, j, archerColumn);
                if(dist > D) { continue; }
                if(dist < minD) {
                    minD = dist;
                    minR = i;
                    minC = j;
                } else if(dist == minD) {
                    if (j < minC) {
                        minR = i;
                        minC = j;
                    }
                }
            }
        }
        if(minD != Integer.MAX_VALUE) {
            visited[minR][minC] = true;
        }
    }
    static int killEnemyAndCount() {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j]) {
                    cnt++;
                    enemies[i][j] = 0;

                }
            }
        }
        return cnt;
    }
    static int getDistance(int r, int c, int archerColumn) {
        return (N-r) + Math.abs(archerColumn - c);
    }
    static void init() {
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                enemies[i][j] = arr[i][j];
            }
        }
    }
    static void updateEnemyPos(int n) {
        for(int i=N-1; i>=n+1; i--) {
            for(int j=0; j<M; j++) {
                enemies[i][j] = enemies[i-1][j];
            }
        }
        for(int j=0; j<M; j++) {
            enemies[n][j] = 0;
        }
    }
}
