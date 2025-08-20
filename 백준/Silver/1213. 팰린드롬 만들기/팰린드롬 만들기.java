import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
//        Map<Character, Integer> map = new TreeMap<>();
//        map.put('B', 8);
//        map.put('A', 4);
//        for(char c : map.keySet()) {
//            System.out.println(c);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // str의 크기가 짝수라면 알파벳이 모두 짝수 개여야 하고, str 크기가 홀수라면 한 개 알파벳만 홀수, 나머지는 짝수 개여야 한다.
        int odd = 0;
        Map<Character, Integer> map = new TreeMap<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        char oddChar = '0';
        for(char c : map.keySet()) {
            if(map.get(c) % 2 == 1) {
                odd++;
                oddChar = c;
            }
            if(odd > 1) break;
        }
        if(odd>1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }


        char[] charArr = new char[str.length()];
        // 문자열 길이가 홀수인 경우
        if(str.length() % 2 == 1) {
            charArr[str.length()/2] = oddChar;
            map.put(oddChar, map.get(oddChar)-1);
            if(map.get(oddChar) == 0) {
                map.remove(oddChar);
            }
        }
        for(int i=0; i<str.length()/2; i++) {
            for(char c : map.keySet()) {
                charArr[i] = c;
                charArr[str.length()-1-i] = c;
                if(map.get(c) == 2) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c)-2);
                }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : charArr) {
            sb.append(c);
        }
        System.out.println(sb);


    }
}
