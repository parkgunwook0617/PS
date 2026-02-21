import java.io.*;
import java.util.*;

public class P2357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());

        int[] numberList = new int[number];
        int[] minTree = new int[4 * number];
        int[] maxTree = new int[4 * number];

        for(int i = 0; i < number; i++) {
            numberList[i] = Integer.parseInt(br.readLine());
        }

        init(numberList, minTree, 1, 0, number - 1, 'S');
        init(numberList, maxTree, 1, 0, number - 1, 'B');

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int min = query(minTree, 1, 0, number - 1, from - 1, to - 1, 'S');
            int max = query(maxTree, 1, 0, number - 1, from - 1, to - 1, 'B');

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    public static void init(int[] numberList, int[] tree, int node, int start, int end, char mode) {
        if(start == end) {
            tree[node] = numberList[start];
            return;
        }

        init(numberList, tree, 2 * node, start, (start + end) / 2, mode);
        init(numberList, tree, 2 * node + 1, (start + end) / 2 + 1, end, mode);

        if(mode == 'B') {
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        } else {
            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
        }
    }

    public static int query(int[] tree, int node, int start, int end, int left, int right, char mode) {
        if(start > right || end < left) {
            if(mode == 'B') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if(start >= left && end <= right) {
            return tree[node];
        }

        int leftQ = query(tree, 2 * node, start, (start + end) / 2, left, right, mode);
        int rightQ = query(tree, 2 * node + 1, (start + end) / 2 + 1, end, left, right, mode);

        if(mode == 'B') {
            return Math.max(leftQ, rightQ);
        } else {
            return Math.min(leftQ, rightQ);
        }
    }
}
