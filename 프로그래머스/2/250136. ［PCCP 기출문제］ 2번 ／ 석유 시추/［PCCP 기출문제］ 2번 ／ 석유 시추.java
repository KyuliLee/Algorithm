import java.util.*;
class Solution {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        // land가 0이면 빈 땅, 1이면 석유
        // 방문 체크 배열 생성
        // land 돌면서 석유 만나면 덩어리 사이즈 찾기
        // 석유가 있는 column을 set에 저장, 해당 덩어리를 다 돌아서 사이즈를 찾으면 
        // set을 돌면서 element를 인덱스로 하는 배열arr에 해당 덩어리 사이즈 저장
        // land 다 돌면서 덩어리 다 찾고 나면 arr에서 최댓값 찾아서 리턴
        boolean[][] visited = new boolean[N][M];
        int[] arr = new int[M]; // 크기 : column size
        
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(land[r][c]==0 || visited[r][c]) { // 빈 땅이거나 방문했으면 넘어감
                    continue;
                }
                
                // 석유 발견했으면 거기서부터 크기 1 시작
                Set<Integer> set = new HashSet<>();
                int chunkSize = 1;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] {r, c});
                visited[r][c] = true;
                while(!q.isEmpty()) {
                    int[] currPos = q.poll();
                    int currR = currPos[0];
                    int currC = currPos[1];
                    set.add(currC); // 석유가 있는 컬럼을 set에 저장
                    
                    for(int d=0; d<4; d++) {
                        int nr = currR + dr[d];
                        int nc = currC + dc[d];
                        if(isValid(nr, nc) && land[nr][nc]==1 && !visited[nr][nc]) {
                            q.offer(new int[] {nr, nc});
                            visited[nr][nc] = true;
                            chunkSize++;
                        }
                    }
                } // 이번 덩어리 다 찾음
                
                // 현재 set에 있는 컬럼을 인덱스로 해서 chunkSize 저장
                for(int col : set) {
                    arr[col] += chunkSize;
                }
            } 
        }
        // arr의 최댓값 리턴
        return Arrays.stream(arr).max().getAsInt();
    }
    static boolean isValid(int r, int c) {
        if(r>=0 && r<N && c>=0 && c<M) {
            return true;
        }
        return false;
    }
}