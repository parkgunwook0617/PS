import java.io.*;
import java.util.*;

public class P11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int commandCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < commandCount; i++) {
            int command = Integer.parseInt(br.readLine());

            if(command == 0) {
                if(pq.peek() == null) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(command);
            }
        }
    }
}
