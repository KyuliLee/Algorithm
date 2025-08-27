import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length());
    static String temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        pq.offer("101");
//        pq.offer("12");
//        while(!pq.isEmpty()) {
//            System.out.println(pq.poll());
//        }

        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++) {
            String str = br.readLine();
            temp = "";
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(c < 'a') {
                    temp += c;
                } else if(temp.length() > 0) {
                    func(temp);
                }
            }
            if(temp.length() > 0) {
                func(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);

    }
    static void func(String str) {
        while(str.length() >= 1 && str.charAt(0) == '0') {
            str = str.substring(1, str.length());
        }
        if(str.length() == 0) {
            str = "0";
        }
        pq.offer(str);
        temp = "";
    }
}
