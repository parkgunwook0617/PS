import java.io.*;
import java.util.*;

public class P11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[size + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[size + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= size; i++) {
            int current = arr[i];

            if(deque.isEmpty()) {
                deque.addFirst(i);
            } else {
                while(!deque.isEmpty() && arr[deque.peekLast()] > current) {
                    deque.pollLast();
                }

                deque.addLast(i);

                if (deque.peekFirst() <= i - L) {
                    deque.pollFirst();
                }
            }

            result[i] = arr[deque.peekFirst()];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= size; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
