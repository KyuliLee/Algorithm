import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 형식 : 55-50+40
        // 1. 숫자와 부호를 분리
        // 2. 연산 결과가 최솟값이 되도록 괄호를 적절히 사용한다 => 마이너스가 한 번이라도 나오면 그 이하의 숫자는 모두 빼면 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 입력 식의 길이 <= 50 이므로 한자리 숫자만 나오는 경우에 많아야 숫자 25개, 연산자 24개
        int[] nums = new int[25];
        int numIdx = 0; // 숫자 들어있는 인덱스의 최댓값
        char[] cmd = new char[24];
        int cmdIdx = 0;
        for(int i=0; i<input.length(); i++) {
            char a = input.charAt(i);

            int numA = 0;
            // 숫자인 경우
            if(a-'0' >=0 && a-'0'<=9) {
                numA = a-'0';
                // 아직 해당 방에 값이 없을 경우
                if(nums[numIdx] == 0) {
                    if(numA == 0) {
                        continue;
                    } else {
                        nums[numIdx] = numA;
                    }
                } else {
                    // 해당 방에 이미 숫자가 있는데 또 숫자면 십, 백, 천, 만의 자리 수이다.
                    nums[numIdx] = nums[numIdx]*10 + numA;
                }
            } else {
                // 연산자가 나오면 연산자 인덱스와 숫자 인덱스 모두 1 증가시켜줌
                cmd[cmdIdx++] = a;
                numIdx++;
            }
        }
        int result = nums[0];
        int j=0;
        boolean minusOnce = false; // 한 번이라도 마이너스가 나오면 true로 변경
        for(int i=1; i<=numIdx; i++) {
            if(cmd[j] == '-') {
                minusOnce = true;
            }
            if(minusOnce) {
                result -= nums[i];
            } else {
                result += nums[i];
            }
            j++;
        }
        System.out.println(result);
    }
}