package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_12100_2048_easy {
    static final int LIMIT = 5;
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int UP = 2;
    static final int DOWN = 3;
    static final int EMPTY = 0;
    static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static Deque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // map 초기화 완료
        for (int i = 0; i < 4; i++) {
            dfs(cloneMap(map), i, 0);
        }
        System.out.println(max);
    }

    static void dfs(int[][] map, int dir, int depth) {
        // 종료 조건
        if(depth == LIMIT) {
            return;
        }
        // 재귀 부분
        switch(dir) {
            case LEFT: {
                left(map);
                break;
            }
            case RIGHT: {
                right(map);
                break;
            } case UP: {
                up(map);
                break;
            } case DOWN: {
                down(map);
                break;
            }
        }
        for(int i=0; i<4; i++) {
            dfs(cloneMap(map), i, depth+1);
        }
    }

    static void left(int[][] map) {
        for(int row=0; row<N; row++) {
            // 왼 쪽으로 밀 때 오른 쪽부터 스택에 쌓기
            for(int col=N-1; col>=0; col--) {
                int n = map[row][col];
                if(n != EMPTY) {
                    stack.push(n);
                    map[row][col] = EMPTY;
                }
            }
            // 왼쪽부터 채우기, 최댓값 비교
            for(int col=0; !stack.isEmpty(); col++) {
                map[row][col] = stack.pop();
                if(!stack.isEmpty() && stack.peek() == map[row][col]) {
                    map[row][col] += stack.pop();
                }
                max = Math.max(max, map[row][col]);
            }
        }
    }

    static void right(int[][] map) {
        for(int row=0; row<N; row++) {
            // 오른 쪽으로 밀 때 왼 쪽부터 스택에 쌓기
            for(int col=0; col<N; col++) {
                int n = map[row][col];
                if(n != EMPTY) {
                    stack.push(n);
                    map[row][col] = EMPTY;
                }
            }
            // 오른쪽부터 채우기, 최댓값 비교
            for(int col=N-1; !stack.isEmpty(); col--) {
                map[row][col] = stack.pop();
                if(!stack.isEmpty() && stack.peek() == map[row][col]) {
                    map[row][col] += stack.pop();
                }
                max = Math.max(max, map[row][col]);
            }
        }
    }

    static void up(int[][] map) {
        for(int col=0; col<N; col++) {
            // 위로 밀 때 아래부터 스택에 쌓기
            for(int row=N-1; row>=0; row--) {
                int n = map[row][col];
                if(n != EMPTY) {
                    stack.push(n);
                    map[row][col] = EMPTY;
                }
            }
            // 위부터 채우기, 최댓값 비교
            for(int row=0; !stack.isEmpty(); row++) {
                map[row][col] = stack.pop();
                if(!stack.isEmpty() && stack.peek() == map[row][col]) {
                    map[row][col] += stack.pop();
                }
                max = Math.max(max, map[row][col]);
            }
        }
    }

    static void down(int[][] map) {
        for(int col=0; col<N; col++) {
            // 아래쪽으로 밀 때 위쪽부터 스택에 쌓기
            for(int row=0; row<N; row++) {
                int n = map[row][col];
                if(n != EMPTY) {
                    stack.push(n);
                    map[row][col] = EMPTY;
                }
            }
            // 아래쪽부터 채우기, 최댓값 비교
            for(int row=N-1; !stack.isEmpty(); row--) {
                map[row][col] = stack.pop();
                if(!stack.isEmpty() && stack.peek() == map[row][col]) {
                    map[row][col] += stack.pop();
                }
                max = Math.max(max, map[row][col]);
            }
        }
    }

    static int[][] cloneMap(int[][] map) {
        int[][] newMap = new int[N][N];
        for(int i=0; i<N; i++) {
            newMap[i] = Arrays.copyOf(map[i], N);
        }
        return newMap;
    }



}
