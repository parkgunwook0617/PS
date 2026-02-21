import java.io.*;
import java.util.*;

public class P11505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        long[] numberList = new long[number];
        long[] tree = new long[4 * number];

        for(int i = 0; i < number; i++) {
            numberList[i] = Long.parseLong(br.readLine());
        }

        init(numberList, tree, 1, 0, number - 1);

        for(int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if(command == 1) {
                update(numberList, tree, 1, 0, number - 1, v1 - 1, v2);
            } else {
                System.out.println(query(tree, 1, 0, number - 1, v1 - 1, v2 - 1));
            }
        }
    }

    public static void init(long[] numberList, long[] tree, int node, int start, int end) {
        if(start == end) {
            tree[node] = numberList[start];
            return;
        }

        init(numberList, tree, 2 * node, start, (start + end) / 2);
        init(numberList, tree, 2 * node + 1, (start + end) / 2 + 1, end);

        tree[node] = (tree[2 * node] * tree[2 * node + 1]) % 1000000007L;
    }

    public static long query(long[] tree, int node, int start, int end, int left, int right) {
        if(start > right || end < left) {
            return 1;
        }

        if(start >= left && end <= right) {
            return tree[node];
        }

        long lProduct = query(tree, 2 * node, start, (start + end) / 2, left, right);
        long rProduct = query(tree, 2 * node + 1, (start + end) / 2 + 1, end, left, right);

        return (lProduct * rProduct) % 1000000007L;
    }

    public static void update(long[] numberList, long[] tree, int node, int start, int end, int index, long val) {
        if(index < start || index > end) {
            return;
        }

        if(start == end) {
            numberList[index] = val;
            tree[node] = val;
            return;
        }

        update(numberList, tree,node * 2, start, (start + end) / 2, index, val);
        update(numberList, tree,node * 2 + 1, (start + end) / 2 + 1, end, index, val);

        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1000000007L;
    }
}
