import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();


            if(cmd.equals("add")) {
                int n = Integer.parseInt(st.nextToken());
                set.add(n);
            } else if(cmd.equals("remove")) {
                int n = Integer.parseInt(st.nextToken());
                set.remove(n);
            } else if(cmd.equals("check")) {
                int n = Integer.parseInt(st.nextToken());
                if(set.contains(n)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if(cmd.equals("toggle")) {
                int n = Integer.parseInt(st.nextToken());
                if(set.contains(n)) {
                    set.remove(n);
                } else {
                    set.add(n);
                }
            } else if(cmd.equals("all")) {
                set.clear();
                for(int j=1; j<=20; j++) {
                    set.add(j);
                }
            } else {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}