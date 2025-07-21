import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String str = br.readLine();
        Node head = new Node(' ');
        Node tail = head;

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            Node node = new Node(c);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        Node cursor = tail;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if(cmd == 'P') {
                char c = st.nextToken().charAt(0);
                Node newNode = new Node(c);
                newNode.prev = cursor;
                newNode.next = cursor.next;
                if(cursor.next != null) {
                    cursor.next.prev = newNode;
                }
                cursor.next = newNode;
                cursor = newNode;
            } else if(cmd == 'L') {
                if(cursor != head) {
                    cursor = cursor.prev;
                }
            } else if(cmd == 'B') {
                if(cursor != head) {
                    cursor.prev.next = cursor.next;
                    if(cursor.next != null) {
                        cursor.next.prev = cursor.prev;
                    }
                    cursor = cursor.prev;
                }
            } else {
                if(cursor.next != null) {
                    cursor = cursor.next;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Node node = head.next;
        while(node != null) {
            sb.append(node.c);
            node = node.next;
        }
        System.out.println(sb);
    }
}