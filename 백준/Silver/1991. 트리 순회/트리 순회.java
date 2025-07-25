import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    char value;
    Node left;
    Node right;
    public Node(char value) {
        this.value = value;
    }
}
public class Main {
    static Node head = new Node('A');
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char rootValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);
            insertNode(head, rootValue, leftValue, rightValue);
        }
        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);

    }
    static void insertNode(Node temp, char rootValue, char leftValue, char rightValue) {
        if(temp.value == rootValue) {
            if(leftValue == '.') {
                temp.left = null;
            } else {
                temp.left = new Node(leftValue);
            }
            if(rightValue == '.') {
                temp.right = null;
            } else {
                temp.right = new Node(rightValue);
            }
        } else {
            if(temp.left != null) {
                insertNode(temp.left, rootValue, leftValue, rightValue);
            }
            if(temp.right != null) {
                insertNode(temp.right, rootValue, leftValue,rightValue);
            }
        }
    }
    static void preorder(Node node) {
        System.out.print(node.value);
        if(node.left != null) {
            preorder(node.left);
        }
        if(node.right != null) {
            preorder(node.right);
        }
    }
    static void inorder(Node node) {
        if(node.left != null) {
            inorder(node.left);
        }
        System.out.print(node.value);
        if(node.right != null) {
            inorder(node.right);
        }
    }
    static void postorder(Node node) {
        if(node.left != null) {
            postorder(node.left);
        }
        if(node.right != null) {
            postorder(node.right);
        }
        System.out.print(node.value);
    }
}
