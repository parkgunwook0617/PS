import java.io.*;
import java.util.*;

public class P2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ballonCount = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<int[]>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < ballonCount; i++) {
            int[] value = new int[2];
            value[0] = Integer.parseInt(st.nextToken());
            value[1] = i + 1;
            deque.add(value);
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            int[] object = deque.pollFirst();
            int step = object[0];
            int number = object[1];

            if(deque.isEmpty()) {
                sb.append(number);
                break;
            }

            if(step < 0) {
                for(int i = 0; i < Math.abs(step); i++) {
                    int[] nextValue = deque.pollLast();
                    deque.addFirst(nextValue);
                }
            } else {
                for(int i = 0; i < step - 1; i++) {
                    int[] nextValue = deque.pollFirst();
                    deque.addLast(nextValue);
                }
            }

            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }
}
