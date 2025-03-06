import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus {
    int r;
    int c;
    int sec;
    public Virus(int r, int c, int sec) {
        this.r = r;
        this.c = c;
        this.sec = sec;
    }
}
public class Main {
    static int N, M;
    static int[][] arr;
    static List<Virus> virusList = new ArrayList<>();
    static Queue<Virus> activeVirusQueue = new LinkedList<>();
    static int virusNumber = 0;
    static boolean[] combVisited;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int zeroNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 연구소 크기
        M = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스 수
        arr = new int[N][N];
        virusList.add(new Virus(-1, -1, -1)); // 0번째 인덱스는 안 쓸 것임
        // 전체 바이러스의 개수에서 M개를 순서 없이 뽑고 -> 조합 사용, M개를 리스트에 넣는다
        // 조합의 모든 경우의 수에서 모든 빈 칸에 바이러스를 퍼뜨릴 때 걸리는 시간을 확인
        // 모든 빈 칸을 감염시켰다면 비활성 바이러스가 있어도 종료
        // 0이 아예 없는 경우가 있으므로 그럴 때는 0 출력하고 리턴

        zeroNum = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    virusList.add(new Virus(i, j, 0));
                }
                if(arr[i][j] == 0) {
                    zeroNum++;
                }
            }
        }
        if(zeroNum == 0) {
            System.out.println(0);
            return;
        }
        virusNumber = virusList.size()-1;
        combVisited = new boolean[virusNumber+1]; // 초기화 완료

        // virusNumber개에서 M개 뽑기
        comb(virusNumber, M, 1, 0);

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
    // 1~NN까지의 숫자 중에서 M개 뽑기
    static void comb(int NN, int M, int start, int depth) {
        if(depth == M) {
            // 조합이 완성될 때마다 방문 배열 새로 만든다
            boolean[][] labsVisited = new boolean[N][N];
            // M개의 Virus는 visited에서 true인 인덱스(NN개 중 M개)
            // M개의 Virus 인덱스를 virusList에서 찾아서 activeVirusQueue에 추가, 방문 처리
            for(int i = 1; i<= NN; i++) {
                if(combVisited[i]) {
                    Virus virus = virusList.get(i);
                    activeVirusQueue.offer(virus);
                    labsVisited[virus.r][virus.c] = true;
                }
            }

            // 초기 방문 처리 : 벽만.
            // 비활성화 바이러스를 방문 처리 안 하는 이유 : 비활성화 바이러스를 방문한 다음 빈 칸을 감염시키는 경우가 있기 때문.
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] == 1) {
                        labsVisited[i][j] = true;
                    }
                }
            }

            // bfs - activeVirusQueue의 바이러스들로 모든 빈 칸***에 바이러스를 퍼뜨릴 때 걸리는 시간 알아내서 min과 비교
            int zeroNum2 = 0;
            int maxSec = 0; // 이번 조합에서 몇 초가 지나야 모든 빈 칸*** 바이러스가 퍼지는지 저장
            while(!activeVirusQueue.isEmpty()) {
                Virus curr = activeVirusQueue.poll();
                // 방문한 빈 칸*** 의 개수가 원래 빈 칸의 개수와 같다면 반복 종료
                if(zeroNum2 == zeroNum) {
                    maxSec = Math.max(maxSec, curr.sec);
                    break;
                }
                for(int d=0; d<4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    if(nr<0 || nr>=N || nc<0 || nc>=N) {
                        continue;
                    }
                    // 빈 칸이고 방문 안 했으면 방문 처리, 큐에 넣음
                    // 비활성화 바이러스이고 방문 안 했으면 방문 처리, 큐에 넣음
                    if(arr[nr][nc]==0 && !labsVisited[nr][nc]) {
                        labsVisited[nr][nc] = true;
                        activeVirusQueue.offer(new Virus(nr, nc, curr.sec+1));
                        zeroNum2++;
                    } else if(arr[nr][nc]==2 && !labsVisited[nr][nc]) {
                        labsVisited[nr][nc] = true;
                        activeVirusQueue.offer(new Virus(nr, nc, curr.sec+1));
                    }
                }
            }
            while(!activeVirusQueue.isEmpty()) {
                maxSec = Math.max(maxSec, activeVirusQueue.poll().sec);
            }
            // 큐를 다 돌고 끝난 뒤 모든 빈 칸***이 방문 처리가 되어 있어야 maxSec과 min을 비교
            // 만약 방문 처리가 다 되어있지 않으면 넘어감

            boolean isAllVisited = true;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j]==0 && !labsVisited[i][j]) {
                        isAllVisited = false;
                        break;
                    }
                }
                if(!isAllVisited) {
                    break;
                }
            }

            if(isAllVisited) {
                min = Math.min(min, maxSec);
            }

            // activeVirusQueue 초기화
            activeVirusQueue.clear();
            return;
        }

        for(int i = start; i<=NN; i++) {
            if(combVisited[i]) {
                continue;
            }
            combVisited[i] = true;
            comb(NN, M, i+1, depth+1);
            combVisited[i] = false;
        }
    }
}