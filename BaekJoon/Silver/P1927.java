import java.io.*;
import java.util.*;

public class P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandNumber = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.naturalOrder());

        for(int i = 0; i < commandNumber; i++) {
            long command = Long.parseLong(br.readLine());
            if(command == 0) {
                if(pq.isEmpty()) {
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
