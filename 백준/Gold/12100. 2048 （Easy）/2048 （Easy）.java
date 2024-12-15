import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int maxBlock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] maps = new int[N][N];
        maxBlock = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, maps);
        System.out.println(maxBlock);
    }

    static int findBlock(int[][] maps) {
        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxSum = Math.max(maxSum, maps[i][j]);
            }
        }
        return maxSum;
    }
    static void dfs(int cnt, int[][] maps) {
        if (cnt == 5) {
            int highBlock = findBlock(maps);
            maxBlock = Math.max(maxBlock, highBlock);
            return;
        }
        // 1. 좌 밀어
        int[][] leftMap = mapCopy(maps);
        // 좌로 미는 로직
        pushLeft(leftMap);
        // 다음 단계
        dfs(cnt + 1, leftMap);

        // 2. 우 밀어
        int[][] rightMap = mapCopy(maps);
        // 우로 미는 로직
        pushRight(rightMap);
        // 다음 단계
        dfs(cnt + 1, rightMap);

        // 3. 상 밀어
        int[][] upMap = mapCopy(maps);
        // 상로 미는 로직
        pushUp(upMap);
        // 다음 단계
        dfs(cnt + 1, upMap);

        // 4. 하 밀어
        int[][] downMap = mapCopy(maps);
        // 하로 미는 로직
        pushDown(downMap);
        // 다음 단계
        dfs(cnt + 1, downMap);
    }

    private static void pushDown(int[][] downMap) {
        Stack<Integer> stack = new Stack<>();
        for (int col = 0; col < N; col++) {
            for (int row = N - 1; row >= 0; row--) {
                int num = downMap[row][col];
                if (num != 0) {
                    if (!stack.isEmpty() && stack.peek() == num) {
                        int mergedNum = stack.pop() * 2;
                        stack.push(mergedNum);
                        stack.push(0);
                    } else {
                        stack.push(num);
                    }
                }
                downMap[row][col] = 0;
            }

            int idx = N - 1;
            for (Integer stackNum : stack) {
                if (stackNum != 0) {
                    downMap[idx--][col] = stackNum;
                }
            }
            stack.clear();
        }
    }

    private static void pushUp(int[][] upMap) {
        Stack<Integer> stack = new Stack<>();
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                int num = upMap[row][col];
                if (num != 0) {
                    if (!stack.isEmpty() && stack.peek() == num) {
                        int mergedNum = stack.pop() * 2;
                        stack.push(mergedNum);
                        stack.push(0);
                    } else {
                        stack.push(num);
                    }
                }
                upMap[row][col] = 0;
            }

            int idx = 0;
            for (Integer stackNum : stack) {
                if (stackNum != 0) {
                    upMap[idx++][col] = stackNum;
                }
            }
            stack.clear();
        }
    }

    private static void pushRight(int[][] rightMap) {
        Stack<Integer> stack = new Stack<>();
        for (int row = 0; row < N; row++) {
            for (int col = N - 1; col >= 0; col--) {
                int num = rightMap[row][col];
                if (num != 0) {
                    if (!stack.isEmpty() && stack.peek() == num) {
                        int mergedNum = stack.pop() * 2;
                        stack.push(mergedNum);
                        stack.push(0);
                    } else {
                        stack.push(num);
                    }
                }
                rightMap[row][col] = 0;
            }

            int idx = N - 1;
            for (Integer stackNum : stack) {
                if (stackNum != 0) {
                    rightMap[row][idx--] = stackNum;
                }
            }
            stack.clear();
        }
    }

    private static void pushLeft(int[][] leftMap) {
        // 좌로 미는 로직
        Stack<Integer> stack = new Stack<>();
        for (int row = 0; row < N; row++) {
            // 같은 숫자 찾기
            for (int col = 0; col < N; col++) {
                int num = leftMap[row][col];
                if (num != 0) {
                    if (!stack.isEmpty() && num == stack.peek()) {
                        int mergedNum = stack.pop() * 2;
                        stack.push(mergedNum);
                        // 계산 완료되면 더 연산되면 안되니까 0으로 막자
                        stack.push(0);
                    } else {
                        stack.push(num);
                    }
                }
                leftMap[row][col] = 0;
            }

            // 다시 채우자
            int colIdx = 0;
            for (Integer stackNum : stack) {
                if (stackNum != 0) {
                    leftMap[row][colIdx++] = stackNum;
                }
            }
            stack.clear();
        }
    }

    static int[][] mapCopy(int[][] maps) {
        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(maps[i], 0, copyMap[i], 0, N);
        }
        return copyMap;
    }
}