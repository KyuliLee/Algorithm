import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(br.readLine());
        arr = new int[switchNum+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= switchNum; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int studentNum = Integer.parseInt(br.readLine());
        for(int i=0; i<studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int givenNumber = Integer.parseInt(st.nextToken());

            if(gender == 1) { // 남학생의 경우 받은 숫자의 배수의 스위치 상태를 바꿈
                int temp = givenNumber;
                while(temp <= switchNum) {
                    changeState(temp);
                    temp += givenNumber;
                }
            } else { // 여학생의 경우 받은 숫자의 양 옆 대칭 구간만큼 스위치 상태를 바꿈
                changeState(givenNumber);

                int left = givenNumber-1;
                int right = givenNumber+1;
                while(left >= 1 && right <= switchNum) { // 스위치 범위 안에 들어있는 경우
                    if(arr[left] != arr[right]) break; // 대칭이 아니면 나감

                    changeState(left);
                    changeState(right);

                    left--;
                    right++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(idx <= switchNum) {
            sb.append(arr[idx]).append(" ");
            idx++;
            if((idx-1)%20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }
    static void changeState(int idx) {
        if(arr[idx] == 0) {
            arr[idx] = 1;
        } else {
            arr[idx] = 0;
        }
    }
}
