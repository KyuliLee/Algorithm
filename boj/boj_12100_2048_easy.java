package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_12100_2048_easy {
    static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // map 초기화 완료

        dfs(map, 0);

        System.out.println(max);

    }
    static void dfs(int[][] map, int depth) {
        // 종료 조건
        if(depth == 5) {
            // 최댓값 비교
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] > max) {
                        max = map[i][j];
                    }
                }
            }
            return;
        }
        // 좌로 밀기
        int[][] leftMap = copyMap(map);
        pushLeft(leftMap);
        dfs(leftMap, depth+1);

        // 우로 밀기
        int[][] rightMap = copyMap(map);
        pushRight(rightMap);
        dfs(rightMap, depth+1);

        // 위로 밀기
        int[][] upMap = copyMap(map);
        pushUp(upMap);
        dfs(upMap, depth+1);

        // 아래로 밀기
        int[][] downMap = copyMap(map);
        pushDown(downMap);
        dfs(downMap, depth+1);

    }
    static void pushLeft(int[][] leftMap) {
        Stack<Integer> stack = new Stack<>();
        for(int row=0; row<N; row++) {
            for(int col=0; col<N; col++) {
                int num = leftMap[row][col];
                // 이번 숫자가 0이면 넘어감
                if(num == 0) { continue; }
                // 만약 스택에 숫자가 있고 가장 위의 숫자가 이번 숫자와 같다면 가장 위의 숫자를 빼고 2를 곱한 값을 넣어줌
                if(!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                    stack.push(num*2);
                    // 한 번 연산을 했으면 또 연산이 되면 안 되므로 0으로 구분해줌
                    stack.push(0);
                } else {
                    stack.push(num);
                }
                // 숫자가 있던 자리를 0으로 만듦
                leftMap[row][col] = 0;
            }

            // 숫자 채우기
            int colIdx = 0;
            for(int num : stack) {
                if(num != 0) {
                    leftMap[row][colIdx++] = num;
                }
            }
            stack.clear();
        }
    }

    static void pushRight(int[][] rightMap) {
        Stack<Integer> stack = new Stack<>();
        for(int row=0; row<N; row++) {
            for(int col=N-1; col>=0; col--) {
                int num = rightMap[row][col];
                // 이번 숫자가 0이면 넘어감
                if(num == 0) { continue; }
                // 만약 스택에 숫자가 있고 가장 위의 숫자가 이번 숫자와 같다면 가장 위의 숫자를 빼고 2를 곱한 값을 넣어줌
                if(!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                    stack.push(num*2);
                    // 한 번 연산을 했으면 또 연산이 되면 안 되므로 0으로 구분해줌
                    stack.push(0);
                } else {
                    stack.push(num);
                }
                // 숫자가 있던 자리를 0으로 만듦
                rightMap[row][col] = 0;
            }

            // 숫자 채우기
            int colIdx = N-1;
            for(int num : stack) {
                if(num != 0) {
                    rightMap[row][colIdx--] = num;
                }
            }
            stack.clear();
        }
    }

    static void pushUp(int[][] upMap) {
        Stack<Integer> stack = new Stack<>();
        for(int col=0; col<N; col++) {
            for(int row=0; row<N; row++) {
                int num = upMap[row][col];
                // 이번 숫자가 0이면 넘어감
                if(num == 0) { continue; }
                // 만약 스택에 숫자가 있고 가장 위의 숫자가 이번 숫자와 같다면 가장 위의 숫자를 빼고 2를 곱한 값을 넣어줌
                if(!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                    stack.push(num*2);
                    // 한 번 연산을 했으면 또 연산이 되면 안 되므로 0으로 구분해줌
                    stack.push(0);
                } else {
                    stack.push(num);
                }
                // 숫자가 있던 자리를 0으로 만듦
                upMap[row][col] = 0;
            }

            // 숫자 채우기
            int rowIdx = 0;
            for(int num : stack) {
                if(num != 0) {
                    upMap[rowIdx++][col] = num;
                }
            }
            stack.clear();
        }
    }

    static void pushDown(int[][] downMap) {
        Stack<Integer> stack = new Stack<>();
        for(int col=0; col<N; col++) {
            for(int row=N-1; row>=0; row--) {
                int num = downMap[row][col];
                // 이번 숫자가 0이면 넘어감
                if(num == 0) { continue; }
                // 만약 스택에 숫자가 있고 가장 위의 숫자가 이번 숫자와 같다면 가장 위의 숫자를 빼고 2를 곱한 값을 넣어줌
                if(!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                    stack.push(num*2);
                    // 한 번 연산을 했으면 또 연산이 되면 안 되므로 0으로 구분해줌
                    stack.push(0);
                } else {
                    stack.push(num);
                }
                // 숫자가 있던 자리를 0으로 만듦
                downMap[row][col] = 0;
            }

            // 숫자 채우기
            int rowIdx = N-1;
            for(int num : stack) {
                if(num != 0) {
                    downMap[rowIdx--][col] = num;
                }
            }
            stack.clear();
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            arr[i] = Arrays.copyOf(map[i], N);
        }
        return arr;
    }

}
