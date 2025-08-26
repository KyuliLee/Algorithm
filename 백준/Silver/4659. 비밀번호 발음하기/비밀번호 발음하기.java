import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        boolean containVowel = false;
        boolean series = false;
        boolean sameAlphabetTwice = false;
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

        while(true) {
            str = br.readLine();
            if(str.equals("end")) break;
            containVowel = false;
            series = false;
            sameAlphabetTwice = false;

            sb.append("<").append(str).append(">").append(" ");

            int size = str.length();
            char[] arr = new char[size];
            for(int i=0; i<size; i++) {
                char c = str.charAt(i);
                arr[i] = c;
                if(vowelSet.contains(c)) {
                    containVowel = true;
                }
            }
            int vowelNum = 0;
            int consonantNum = 0;
            for(int i=0; i<size; i++) {
                char c = arr[i];
                if(vowelSet.contains(c)) {
                    vowelNum++;
                    consonantNum = 0;

                    if(vowelNum >= 3) {
                        series = true;
                        break;
                    }
                } else {
                    consonantNum++;
                    vowelNum = 0;

                    if(consonantNum >= 3) {
                        series = true;
                        break;
                    }
                }
            }

            char prev = '!';
            for(int i=0; i<size; i++) {
                char c = arr[i];
                if(prev == c && c != 'e' && c != 'o') {
                    sameAlphabetTwice = true;
                    break;
                }
                prev = c;
            }

            if(containVowel && !series && !sameAlphabetTwice) {
                sb.append("is acceptable.\n");
            } else {
                sb.append("is not acceptable.\n");
            }
        }
        System.out.println(sb);
    }
}
