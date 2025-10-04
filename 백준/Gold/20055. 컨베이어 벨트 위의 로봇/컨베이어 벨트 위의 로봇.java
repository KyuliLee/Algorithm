import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, len;
    static int[] arr;
    static int zeroNum = 0;
    static int stage = 0;
    static boolean[] hasRobot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        len = 2*N;
        arr = new int[len+1];
        hasRobot = new boolean[len+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        while(true) {
            stage++;
            rotate();
            robotDown();

            moveRobot();
            robotDown();

            robotUp();
            if(zeroNum>=K) {
                break;
            }
        }
        System.out.println(stage);


    }
    static void robotDown() {
        hasRobot[N] = false;
    }
    static void robotUp() {
        if(arr[1] >= 2) {
            arr[1]--;
            hasRobot[1] = true;
        } else if(arr[1] == 1) {
            arr[1]--;
            zeroNum++;
            hasRobot[1] = true;
        }

    }
    static void rotate() {
        // 컨베이어벨트와 로봇이 함께 이동
        int temp = arr[len]; // 내구도는 temp가 있어야 하지만 hasRobot은 어차피 false. 내리는 위치에서 로봇 다 내리니까.
        for (int i = len - 1; i >= 1; i--) {
            arr[i + 1] = arr[i];
            hasRobot[i + 1] = hasRobot[i];
        }
        arr[1] = temp;
        hasRobot[1] = false;
    }
    static void moveRobot() {
        for(int i=N-1; i>=2; i--) {
            if(!hasRobot[i]) continue;
            // 다음 위치에 로봇이 이미 있다면 넘어감
            if(hasRobot[i+1]) continue;

            if(arr[i+1] >= 2) {
                hasRobot[i] = false;
                hasRobot[i+1] = true;
                arr[i+1]--;
            } else if(arr[i+1] == 1) {
                hasRobot[i] = false;
                hasRobot[i+1] = true;
                arr[i+1]--;
                zeroNum++;
            }
        }
    }
}
