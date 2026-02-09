import java.io.*;
import java.util.*;

public class P15681 {
    public static List<List<Integer>> list;
    public static List<List<Integer>> child;
    public static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNumber = Integer.parseInt(st.nextToken());
        int rootNode = Integer.parseInt(st.nextToken());
        int queryNumber = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        child = new ArrayList<>();
        size = new int[nodeNumber + 1];
        for(int i = 0; i <= nodeNumber; i++) {
            list.add(new ArrayList<>());
            child.add(new ArrayList<>());
        }

        for(int i = 0; i < nodeNumber - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        makeTree(rootNode, -1);
        countSubTree(rootNode);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < queryNumber; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(size[query]).append("\n");
        }

        System.out.println(sb);
    }

    public static void makeTree(int currentNode, int parent) {
        for(int Node : list.get(currentNode)) {
            if(Node != parent) {
                child.get(currentNode).add(Node);
                makeTree(Node, currentNode);
            }
        }
    }

    public static void countSubTree(int currentNode) {
        size[currentNode] = 1;
        for(int Node : child.get(currentNode)) {
            countSubTree(Node);
            size[currentNode] += size[Node];
        }
    }
}
