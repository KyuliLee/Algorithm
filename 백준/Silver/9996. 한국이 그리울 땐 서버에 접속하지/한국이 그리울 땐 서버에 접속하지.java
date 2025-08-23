import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        int patternLen = pattern.length();
        int patternLastIdx = patternLen -1;
        char[] arr = new char[patternLen];
        int starIdx = 0;
        for(int i = 0; i<patternLen; i++) {
            arr[i] = pattern.charAt(i);
            if(arr[i] == '*') {
                starIdx = i;
            }
        }
        // 파일명의 최소 길이 : 패턴에서 *표를 제외한 만큼의 길이는 있어야 한다
        int minNameLen = patternLen-1;


        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++) {
            String name = br.readLine();

            if(name.length() < minNameLen) {
                sb.append("NE").append("\n");
                continue;
            }

            int nameLastIdx = name.length()-1;
            boolean isSame = true;
            // 만약 str의 길이가 pattern에서 *표까지의 길이보다 짧다면 NE
            if(nameLastIdx < starIdx-1) {
                sb.append("NE").append("\n");
                continue;
            }
            // 만약 str의 길이가 pattern의 *표에서 맨 뒤까지의 길이보다 짧다면 NE
            if(nameLastIdx < (patternLastIdx -starIdx)-1) {
                sb.append("NE").append("\n");
                continue;
            }

            for(int i=0; i<starIdx; i++) {
                if(name.charAt(i) != arr[i]) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) {
                sb.append("NE").append("\n");
                continue;
            }
            for(int i = patternLastIdx, j = nameLastIdx; i>starIdx; i--, j--) {
                if(arr[i] != name.charAt(j)) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) {
                sb.append("NE").append("\n");
                continue;
            }
            sb.append("DA").append("\n");
        }
        System.out.println(sb);
    }
}
