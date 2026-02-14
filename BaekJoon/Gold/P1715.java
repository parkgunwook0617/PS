import java.io.*;
import java.util.*;

public class P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        int number = Integer.parseInt(br.readLine());

        for(int i = 0; i < number; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while(pq.size() > 1) {
            int data1 = pq.poll();
            int data2 = pq.poll();

            int sum = data1 + data2;
            total += sum;
            pq.add(sum);
        }

        System.out.println(total);
    }
}
