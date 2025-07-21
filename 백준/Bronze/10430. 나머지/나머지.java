import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    char c;
    Node prev, next;
    public Node(char c) {
        this.c = c;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long ans1 = (A+B)%C;
        long ans2 = ((A%C)+(B%C))%C;
        long ans3 = (A*B)%C;
        long ans4 = ((A%C)*(B%C))%C;
        StringBuilder sb = new StringBuilder();
        sb.append(ans1).append("\n");
        sb.append(ans2).append("\n");
        sb.append(ans3).append("\n");
        sb.append(ans4);
        System.out.print(sb);

    }
}