import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class SharkPos {
    int r;
    int c;
    int size;
    int time;
    int eatenFishNumberInCurrSize;
    public SharkPos(int r, int c, int size, int time, int eatenFishNumberInCurrSize) {
        this.r = r;
        this.c = c;
        this.size = size;
        this.time = time;
        this.eatenFishNumberInCurrSize = eatenFishNumberInCurrSize;
    }
}
class Pos implements Comparable<Pos>{
    int r;
    int c;
    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Pos o) {
        if(this.r != o.r) { // 가까운 순으로 정렬되어야 하니까 오름차순
            return this.r - o.r;
        }
        return this.c - o.c;
    }
}

public class Main {
    static int N;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sharkSize = 2;
    static int time = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        int sharkR = -1;
        int sharkC = -1;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    arr[i][j] = 0; // 길이 막혀버리지 않게 0으로 바꿔줌
                }
            }
        }
        visited = new boolean[N][N];// 초기화 완료
        // 아기 상어 크기는 2
        // 자기보다 작은 물고기만 먹음, 큰 물고기가 있는 칸은 못 지나감, 같은 크기 물고기는 못 먹고 지나갈 수만 있음
        // 먹을 수 없는 물고기가 없다면 끝
        // 물고기가 2마리 이상이면 가장 가까운 물고기를, 1마리이면 그 물고기를 먹으러 감.
        // 가장 가까운 물고기가 여러 마리면 가장 위에 있는 물고기 -> 가장 왼쪽에 있는 물고기 순으로 먹는다
        // 이동에는 1초가 걸리고 이동과 동시에 먹는다.
        // 자신의 크기 횟수만큼 물고기를 먹을 때 크기가 1 증가함. 처음 크기는 2이므로 2마리를 먹으면 3으로 커짐, 3마리 먹으면 4로 커짐

        /*
        SharkPos 큐에 상어 시작 위치 넣음, 방문 처리, SharkPos 큐가 빌 때까지 반복
            큐에 있는 것 하나 뺌.
            현재 위치부터 사방탐색하기 위한 임시 방문배열, 임시 큐 생성. 현재 상어 위치 임시 큐에 넣고 임시 방문처리.
            사방탐색하면서 arr에 있는 물고기 크기 확인 & 임시 방문처리
            상어보다 작은 물고기들을 pq에 넣음. pq는 r값이 작은 순서 -> c값이 작은 순서
            사방탐색 1번 끝날 때마다 pq에 들어있으면 그 위치로 상어가 이동해야 함.
            pq에 있는 물고기 위치를 큐에 넣음, pq비움, 임시 큐 비움, arr의 해당 위치 값 0으로 변경, 바뀐 상어 위치 큐에 삽입, 방문 처리
            pq에 들어간 게 없으면 임시 큐가 빌 때까지 사방탐색 반복하는데 그러면서 time 증가
         */

        Queue<SharkPos> q = new LinkedList<>();
        q.offer(new SharkPos(sharkR, sharkC, 2, 0, 0));
        visited[sharkR][sharkC] = true;
        while(!q.isEmpty()) {
            SharkPos currPos = q.poll();
            int currR = currPos.r;
            int currC = currPos.c;
            int currSize = currPos.size;
            int time = currPos.time;
            int eatenFish = currPos.eatenFishNumberInCurrSize;
            // 현재 상어 위치에서 사방탐색 하기 위한 임시 방문배열, 임시 큐
            boolean[][] tempVisited = new boolean[N][N];
            Queue<Pos> tempSharkPos = new LinkedList<>();

            tempSharkPos.offer(new Pos(currR, currC));
            tempVisited[currR][currC] = true;
            PriorityQueue<Pos> pq = new PriorityQueue<>();
            int dist = 0;
            boolean found = false;
            while(!tempSharkPos.isEmpty() && !found) {
                // 동일 레벨에 있는 노드들 탐색
                int size = tempSharkPos.size();
                for (int i = 0; i < size; i++) {
                    // 이번 노드에 대해 사방탐색
                    Pos tempCurrPos = tempSharkPos.poll();
                    int tempCurrR = tempCurrPos.r;
                    int tempCurrC = tempCurrPos.c;

                    for (int d = 0; d < 4; d++) {
                        int newR = tempCurrR + dr[d];
                        int newC = tempCurrC + dc[d];

                        if (!isValid(newR, newC) || tempVisited[newR][newC]) {
                            continue;
                        }
                        // 상어보다 물고기가 크면 이동 X
                        if (arr[newR][newC] > currSize) {
                            continue;
                        }
                        if (arr[newR][newC] == 0) { // 물고기가 없으면 이동 가능
                            tempSharkPos.offer(new Pos(newR, newC));
                            tempVisited[newR][newC] = true;
                        } else if (arr[newR][newC] < currSize) { // 상어보다 물고기가 작으면 먹을 수 있음
                            pq.offer(new Pos(newR, newC));
                            found = true;
                            tempVisited[newR][newC] = true;
                        } else if (arr[newR][newC] == currSize) { // 상어와 물고기 크기가 같으면 물고기 자리로 이동 가능
                            tempSharkPos.offer(new Pos(newR, newC));
                            tempVisited[newR][newC] = true;
                        }
                    }
                }
                // 동일 레벨에 있는 노드들 탐색이 끝난 후에 거리 증가
                if (!found) {
                    dist++;
                }
            }
            // 사방탐색을 최대한 했는데 pq가 비어있다면 먹을 수 있는 물고기가 없다는 거니까 시간 출력하고 종료
            if(pq.isEmpty()) {
                System.out.println(time);
                break;
            }
            Pos fishToEat = pq.poll(); // 먹을 물고기가 있는 자리 = 상어가 이동할 자리
            arr[fishToEat.r][fishToEat.c] = 0; // 원본 배열의 물고기를 0으로 만듦
            tempSharkPos.clear(); // 현재 위치의 상어가 이동할 위치 정하기 위한 tempQ를 비움
            // 바뀐 상어 위치를 큐에 삽입
            eatenFish++;
            if(currSize == eatenFish) {
                currSize++;
                eatenFish = 0;
            }
            // 지금 dist는 거리가 3인 물고기를 발견했을 때 dist가 2이므로 2가 그대로 들어감. 거리를 1 증가시켜줘야 한다.
            q.offer(new SharkPos(fishToEat.r, fishToEat.c, currSize, dist + 1 + time, eatenFish));
            // 상어가 이동한 위치 방문 처리
            visited[fishToEat.r][fishToEat.c] = true;

            pq.clear();
        }
    }
    public static boolean isValid(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
