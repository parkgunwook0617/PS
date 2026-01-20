import java.io.*;
import java.util.*;

public class P1991 {
    public static class Node {
        char left;
        char right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    public static HashMap<Character, Node> map = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexNumber = Integer.parseInt(br.readLine());

        for(int i = 0; i < vertexNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            map.put(parent, new Node(left, right));
        }

        preorderTraversal('A');
        sb.append("\n");
        inorderTraversal('A');
        sb.append("\n");
        postorderTraversal('A');

        System.out.println(sb);
    }

    public static void preorderTraversal(char vertex) {
        Node node = map.get(vertex);

        sb.append(vertex);

        if(node.left != '.') {
            preorderTraversal(node.left);
        }

        if(node.right != '.') {
            preorderTraversal(node.right);
        }
    }

    public static void inorderTraversal(char vertex) {
        Node node = map.get(vertex);

        if(node.left != '.') {
            inorderTraversal(node.left);
        }

        sb.append(vertex);

        if(node.right != '.') {
            inorderTraversal(node.right);
        }
    }

    public static void postorderTraversal(char vertex) {
        Node node = map.get(vertex);

        if(node.left != '.') {
            postorderTraversal(node.left);
        }

        if(node.right != '.') {
            postorderTraversal(node.right);
        }

        sb.append(vertex);
    }
}
