import java.io.*;
import java.util.*;

public class P2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        long[] numberList = new long[number];
        for(int i = 0; i < number; i++) {
            numberList[i] = Long.parseLong(br.readLine());
        }

        long[] tree = new long[number * 4];
        init(numberList, tree, 1, 0, number - 1);

        for(int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());
            long targetValue = Long.parseLong(st.nextToken());

            if(command == 1) {
                update(numberList, tree, 1, 0, number - 1, targetIndex - 1, targetValue);
            } else if (command == 2) {
                System.out.println(query(tree, 1, 0, number - 1, targetIndex - 1, (int) targetValue - 1));
            }
        }
    }

    public static void init(long[] numberList, long[] tree, int node, int start, int end) {
        if(start == end) {
            tree[node] = numberList[start];
        } else {
            init(numberList, tree, 2 * node, start, (start + end) / 2);
            init(numberList, tree, 2 * node + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        long lsum = query(tree, node*2, start, (start+end)/2, left, right);
        long rsum = query(tree, node*2+1, (start+end)/2+1, end, left, right);

        return (lsum + rsum);
    }

    public static void update(long[] numberList, long[] tree, int node, int start, int end, int index, long val) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            numberList[index] = val;
            tree[node] = val;
            return;
        }

        update(numberList, tree,node*2, start, (start+end)/2, index, val);
        update(numberList, tree,node*2+1, (start+end)/2+1, end, index, val);

        tree[node] = tree[node*2] + tree[node*2+1];
    }
}
