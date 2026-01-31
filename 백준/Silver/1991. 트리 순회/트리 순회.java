import java.io.*;
import java.util.*;

public class Main {

    static class Node  {
        char value;
        Node left;
        Node right;

        Node (char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // 시작 'A'
    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }
    
    // 노드 연결
    public static void insertNode(Node temp, char root, char left, char right) {
        if (temp.value == root) {
            if (left == '.') temp.left = null;
            else temp.left = new Node(left, null, null);

            if (right == '.') temp.right = null;
            else temp.right = new Node(right, null, null);
        }
        else {
            if (temp.left != null) {
                insertNode(temp.left, root, left, right);
            }
            if (temp.right != null) {
                insertNode(temp.right, root, left, right);
            }
        }
    }

    // 전위
    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위
    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    // 후위
    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}
