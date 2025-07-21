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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ans2 = ((A%C)+(B%C))%C;
        int ans4 = ((A%C)*(B%C))%C;
        StringBuilder sb = new StringBuilder();
        sb.append(ans2).append("\n");
        sb.append(ans2).append("\n");
        sb.append(ans4).append("\n");
        sb.append(ans4);
        System.out.print(sb);

    }
}