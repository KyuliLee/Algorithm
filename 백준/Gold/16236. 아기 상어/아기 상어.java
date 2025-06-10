import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class SharkPos {
    int r;
    int c;
    int size;
    int time;
    int eatenFishNumber;
    public SharkPos(int r, int c, int size, int time, int eatenFishNumber) {
        this.r = r;
        this.c = c;
        this.size = size;
        this.time = time;
        this.eatenFishNumber = eatenFishNumber;
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
        if(this.r != o.r) { // r이 작은 순으로 정렬
            return this.r - o.r;
        }
        return this.c - o.c; // r이 같다면 c가 작은 순으로 정렬
    }
}
public class Main {
    static int N;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
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
                    arr[i][j] = 0; // 시작점을 다시 지니갈 수 있도록 0으로 변경
                }
            }
        } // 초기화 완료

        /* 문제 조건
        아기 상어 초기 크기 2, 1초에 1칸 이동, 물고기 먹는 데에 시간은 들지 않음
        먹을 수 있는 물고기가 1마리면 그 물고기 먹고, 여러 마리면 가장 가까운 물고기 먹음
        가장 가까운 물고기가 여러 마리면 가장 위에 있는 물고기 -> 왼쪽에 있는 물고기 순으로 먹음
        상어 크기와 동일한 개수의 물고기를 먹으면 상어 size up
        상어보다 작은 물고기 => 먹을 수 있음
        상어보다 큰 물고기 => 못 지나감
        상어랑 같은 크기 물고기 => 못 먹음, 지나갈 수 있음
        => 몇 초 동안 물고기를 다 먹을 수 있는지 구하기
         */

        /* 풀이
        shark큐에 현재 위치 넣음, 큐가 빌 때까지 반복
            큐에서 상어 위치 뺌, 사방탐색용 tempPos큐에 상어 위치 넣기, 방문 배열 생성, 물고기 들어갈 pq 생성. pq는 r이 작은 순, c가 작은 순으로 순위가 높음
            tempPos큐에 있는 요소 개수만큼 사방탐색.
            물고기 있으면 크기 확인하고 pq에 넣음
            없으면 tempPos큐에 넣고 사방탐색
            요소 개수만큼 사방탐색 끝나고 pq가 비어있으면 dist++
            pq가 비어있지 않으면 하나 꺼내고 pq비움, 그 위치로 상어 이동
         */

        Queue<SharkPos> q = new LinkedList<>();
        q.offer(new SharkPos(sharkR, sharkC, 2, 0, 0));
        while(!q.isEmpty()) {
            SharkPos sharkPos = q.poll();
            Queue<Pos> tempPos = new LinkedList<>();
            tempPos.offer(new Pos(sharkPos.r, sharkPos.c));
            PriorityQueue<Pos> fishToEat = new PriorityQueue<>();

            int dist = 0;
            // 이번 상어 위치에서 갈 수 있는 곳 탐색에 필요한 방문 배열
            boolean[][] visited = new boolean[N][N];
            while(!tempPos.isEmpty() && fishToEat.isEmpty()) {
                int size = tempPos.size();
                // while문 한 번 돌 때 tempPos에 있는 노드들은 상어 위치로부터의 거리가 일정함. while문 돌 때마다 거리 1 증가시킴
                dist++;
                for(int i=0; i<size; i++) {
                    Pos currPos = tempPos.poll();
                    int currR = currPos.r;
                    int currC = currPos.c;
                    visited[currR][currC] = true;

                    for(int d=0; d<4; d++) {
                        int newR = currR + dr[d];
                        int newC = currC + dc[d];

                        if(!isValid(newR, newC) || visited[newR][newC]) {
                            continue;
                        }
                        // 물고기가 상어보다 크면 넘어감
                        if(arr[newR][newC] > sharkPos.size) {
                            continue;
                        }
                        // 같은 크기의 물고기이면 이동 가능
                        if(arr[newR][newC] == sharkPos.size) {
                            tempPos.offer(new Pos(newR, newC));
                            visited[newR][newC] = true;
                        } else if(arr[newR][newC] == 0) { // 그 칸이 비어있으면 이동 가능
                            tempPos.offer(new Pos(newR, newC));
                            visited[newR][newC] = true;
                        } else { // 상어보다 작은 크기의 물고기면 먹을 수 있음
                            fishToEat.offer(new Pos(newR, newC));
                            visited[newR][newC] = true;
                        }
                    }
                }
            } // 사방탐색 끝
            if(fishToEat.isEmpty()) {
                System.out.println(sharkPos.time);
                break;
            }
            // 가장 가깝고 가장 r이 작고 가장 c가 작은 물고기 자리로 상어 이동
            Pos fish = fishToEat.poll();
            arr[fish.r][fish.c] = 0;
            int newEatenFishNumber = sharkPos.eatenFishNumber + 1;
            if(sharkPos.size == newEatenFishNumber) {
                q.offer(new SharkPos(fish.r, fish.c, sharkPos.size + 1,sharkPos.time + dist, 0));
            } else {
                q.offer(new SharkPos(fish.r, fish.c, sharkPos.size,sharkPos.time + dist, newEatenFishNumber));
            }
        }
    }
    public static boolean isValid(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
