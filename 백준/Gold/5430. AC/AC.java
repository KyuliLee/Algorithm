import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1; tc<=T; tc++) {
            String commands = br.readLine();

            int numbers = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String inputNumbersString = br.readLine();
            String middleTransformationString = inputNumbersString.substring(1, inputNumbersString.length()-1);
            st = new StringTokenizer(middleTransformationString, ",");
            for(int i=0; i<numbers; i++) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }

            boolean isError = false;
            boolean isForward = true;
            // 명령어 실행.
            for(int i=0; i<commands.length(); i++) {
                char cmd = commands.charAt(i);

                if(cmd == 'R') {
                    isForward = !isForward;
                } else {
                    // 배열이 비어있는 경우 반복문 종료
                    if(deque.size() == 0) {
                        isError = true;
                        break;
                    }
                    // 배열이 비어있지 않은 경우
                    // 정방향이면 앞의 숫자 버림, 역방향이면 뒤의 숫자 버림
                    if(isForward) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if(isError) {
                sb.append("error");
            } else {
                // 에러가 나지 않았다면 arr 출력
                sb.append("[");
                int size = deque.size();
                for(int i=0; i<size; i++) {
                    if(isForward) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    if(i != size-1) {
                        sb.append(",");
                    }
                }
                sb.append("]");
            }
            System.out.println(sb);
        }
    }
}