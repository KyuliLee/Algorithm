import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
한 이닝에 3아웃, N이닝 진행
안타 1, 2루타 2, 3루타 3, 홈런 4, 아웃 0
이닝 시작 시 주자는 없음, 홈까지 오면 1점 득점
9번 타자까지 쳤어도 3아웃 안 된 상태면 다시 1번타자가 침
3아웃 됐을 때 n번 타자까지 쳤으면 다음 이닝에서 1번 타자가 아니라 n+1타자 차례
1번 선수는 4번 타자 고정.


 */
public class Main {
    static int N;
    static int[][] arr;
    static int[] ans = new int[10];
    static int max = Integer.MIN_VALUE;
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[][] arr = new int[2][3];
//        arr[0][0] = 0;
//        arr[0][1] = 1;
//        arr[0][2] = 2;
//        arr[1][0] = 3;
//        arr[1][1] = 4;
//        arr[1][2] = 5;
//        System.out.println(Arrays.toString(arr[0]));
//        System.out.println(Arrays.toString(arr[1]));
//        int[] tempArr = arr[0];
//        arr[0] = arr[1];
//        arr[1] = tempArr;
//        System.out.println(Arrays.toString(arr[0]));
//        System.out.println(Arrays.toString(arr[1]));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][10];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans[4] = 1; // ans는 인덱스 번호에 타자인 선수 번호 저장하는 배열. 4번 타자는 항상 1번 선수로 고정
        visited[1] = true; // 선수번호 1번은 이미 방문했으니 아무데도 못 들어감
        /*
        백트래킹으로 1~9에서 4를 제외한 순열을 구해서 ans에 저장하고 야구 룰 계산
         */
        dfs(1);
        System.out.println(max);

    }
    static void dfs(int depth) {
        if(depth > 9) {
            int res = cal();
            max = Math.max(max, res);

//            if(ans[1] == 2 && ans[2] == 3 && ans[3] == 4 && ans[5] == 6 && ans[6] == 7 && ans[7] == 8 && ans[8] == 9) {
//                int res = cal();
//                max = Math.max(max, res);
//            }
            return;
        }
        // depth는 타자 번호. 4번 타자는 1번 선수로 고정되었으니 넘어감
        if(depth == 4) {
            dfs(depth+1);
            return;
        }
        //  1번 선수는 4번 타자로 고정되었으니 for문 안 돈다.
        for(int i=2; i<=9; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            ans[depth] = i;
            dfs(depth+1);
            visited[i] = false;
        }
    }
    static int cal() {
        int inning = 0;
        int batter = 0; // 타자 번호
        int score = 0;
        while(inning < N) {
            int out = 0;
            boolean[] person = new boolean[4]; // 0은 안 쓰고 1, 2, 3루에 사람이 있으면 true, 없으면 false.
            while(out < 3) {
                person[0] = true; // 타석에 있으니까 true라고 친다.
                batter++;
                if(batter == 10) {
                    batter = 1;
                }
                int player = ans[batter];
                int n = arr[inning][player]; // 공 친 결과
                // 아웃이면 아웃 1 증가, 넘어감
                if(n == 0) {
                    out++;
                    continue;
                }
                // 위치 이동
                for(int i=3; i>=0; i--) {
                    // i루에 사람이 없으면 넘어감
                    if(!person[i]) {
                        continue;
                    }
                    // 홈 도착
                    if(i+n > 3) {
                        person[i] = false;
                        score++;
                    } else { // 타수 만큼 이동
                        person[i] = false;
                        person[i+n] = true;
                    }
                }

            }

            // 3아웃이면 이닝 새로 시작
            if(out == 3) {
                inning++;
            }
        }
        return score;
    }
}
