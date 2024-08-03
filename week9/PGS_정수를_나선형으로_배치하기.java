class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;
        int num = 2;
        int d = 0; // 방향 나타냄
        int r = 0; // answer[r][c] : 현재 위치
        int c = 0;
        while(num <= n*n) {
            while(d==0) {
                if(c+1 < n && answer[r][c+1] == 0) {
                    answer[r][c+1] = num;
                    num++;
                    c++;
                } else {
                    d++;
                }
            }
            while(d==1) {
                if(r+1 < n && answer[r+1][c] == 0) {
                    answer[r+1][c] = num;
                    num++;
                    r++;
                } else {
                    d++;
                }
            }
            while(d==2) {
                if(c-1 >=0 && answer[r][c-1] == 0) {
                    answer[r][c-1] = num;
                    num++;
                    c--;
                } else {
                    d++;
                }
            }
            while(d==3) {
                if(r-1 >=0 && answer[r-1][c] == 0) {
                    answer[r-1][c] = num;
                    num++;
                    r--;
                } else {
                    d = 0;
                }
            }
            
        }
        return answer;
    }
}
