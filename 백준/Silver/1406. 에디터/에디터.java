import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
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
            Node newNode = new Node(str.charAt(i));
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        Node cursor = tail;

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch(cmd) {
                case('P'): {
                    char c = st.nextToken().charAt(0);
                    Node newNode = new Node(c);
                    newNode.prev = cursor;
                    newNode.next = cursor.next;
                    if(cursor.next != null) {
                        cursor.next.prev = newNode;
                    }
                    cursor.next = newNode;
                    cursor = newNode;

                    break;
                }
                case('L'): {
                    if(cursor.prev != null) {
                        cursor = cursor.prev;
                    }
                    break;
                }
                case('D'): {
                    if(cursor.next != null) {
                        cursor = cursor.next;
                    }
                    break;
                }
                case('B'): {
                    if(cursor != head) {
                        Node del = cursor;
                        cursor = cursor.prev;
                        cursor.next = del.next;
                        if(del.next != null) {
                            cursor.next.prev = cursor;
                        }
                    }
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Node curr=head.next; curr != null; curr = curr.next) {
            sb.append(curr.c);
        }
        System.out.println(sb);

    }
}