import java.io.*;
import java.util.*;

public class P5639 {
    public static class Node {
        int left = 0;
        int right = 0;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        Node() {}
    }

    public static HashMap<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value;
        List<Integer> elements = new ArrayList<>();
        while((value = br.readLine()) != null) {
            elements.add(Integer.parseInt(value));
        }
        map.put(elements.get(0), new Node());

        for(int i = 1; i < elements.size(); i++) {
            int parentNode = elements.get(0);

            while(true) {
                if(elements.get(i) > parentNode) {
                    if(map.get(parentNode).right == 0) {
                        map.put(parentNode, new Node(map.get(parentNode).left, elements.get(i)));
                        map.put(elements.get(i), new Node());
                        break;
                    } else {
                        parentNode = map.get(parentNode).right;
                    }
                } else {
                    if(map.get(parentNode).left == 0) {
                        map.put(parentNode, new Node(elements.get(i), map.get(parentNode).right));
                        map.put(elements.get(i), new Node());
                        break;
                    } else {
                        parentNode = map.get(parentNode).left;
                    }
                }
            }
        }

        postorderTraversal(elements.get(0));
    }

    public static void postorderTraversal(int vertex) {
        Stack<Integer> progress = new Stack<>();
        Stack<Integer> end = new Stack<>();

        progress.add(vertex);
        while(!progress.empty()) {
            int parent = progress.pop();
            end.add(parent);

            if(map.get(parent).left != 0) {
                progress.add(map.get(parent).left);
            }

            if(map.get(parent).right != 0) {
                progress.add(map.get(parent).right);
            }
        }

        while(!end.empty()) {
            System.out.println(end.pop());
        }
    }
}
