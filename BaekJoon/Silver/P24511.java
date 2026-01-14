import java.io.*;
import java.util.*;

public class P24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] type = new int[count];
        long[] value = new long[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++) {
            value[i] = Long.parseLong(st.nextToken());
        }

        int length = Integer.parseInt(br.readLine());
        long[] suyol = new long[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++) {
            suyol[i] = Long.parseLong(st.nextToken());
        }

        Deque<Long> deque = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            if (type[i] == 0) {
                deque.addLast(value[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            deque.addFirst(suyol[i]);
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}
