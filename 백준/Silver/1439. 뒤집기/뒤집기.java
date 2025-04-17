import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] charArr = str.toCharArray();
        int len = charArr.length;;
        int[] arr = new int[len];
        for(int i=0; i<len; i++) {
            arr[i] = charArr[i]-'0';
        }

        // 1인 구간의 개수, 0인 구간의 개수 중 작은 것 출력
        int num1 = 0;
        int num0 = 0;
        boolean isPrev0 = true;
        if(arr[0] == 0) {
            num0++;
        }
        for(int i=0; i<len; i++) {
            if(isPrev0) { // 앞의 숫자가 0인 경우
                if(arr[i] == 1) { // 현재 숫자가 1
                    isPrev0 = false;
                    num1++;
                } else { // 현재 숫자가 0
                    continue;
                }
            } else { // 앞의 숫자가 1인 경우
                if(arr[i] == 1) { // 현재 숫자가 1
                    continue;
                } else { // 현재 숫자가 0
                    isPrev0 = true;
                    num0++;
                }
            }
        }
        System.out.println(Math.min(num1, num0));
    }
}
