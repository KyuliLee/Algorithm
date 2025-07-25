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
    static Node[] nodes = new Node[26];      // 'A' ~ 'Z'
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in  = new StringBuilder();
    static StringBuilder post= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 루트 A 노드 미리 생성
        nodes[0] = new Node('A');

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char r = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char rr= st.nextToken().charAt(0);

            int ri = r - 'A';
            if (nodes[ri] == null) nodes[ri] = new Node(r);

            if (l != '.') {
                int li = l - 'A';
                if (nodes[li] == null) nodes[li] = new Node(l);
                nodes[ri].left = nodes[li];
            }
            if (rr != '.') {
                int rri = rr - 'A';
                if (nodes[rri] == null) nodes[rri] = new Node(rr);
                nodes[ri].right = nodes[rri];
            }
        }

        // 한 번 순회하면서 StringBuilder에 차곡차곡 저장
        preorder (nodes[0]);
        inorder  (nodes[0]);
        postorder(nodes[0]);

        // 출력은 한 번만
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void preorder(Node n) {
        if (n == null) return;
        pre.append(n.value);
        preorder(n.left);
        preorder(n.right);
    }
    static void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        in.append(n.value);
        inorder(n.right);
    }
    static void postorder(Node n) {
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        post.append(n.value);
    }
}