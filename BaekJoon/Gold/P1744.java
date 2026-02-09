import java.io.*;
import java.util.*;

public class P1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] list = new int[size];
        for(int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        for(int i = 0; i < size; i++) {
            pq.add(list[i]);
        }

        int max = 0;
        while(!pq.isEmpty()) {
            int candidate = pq.poll();

            if(candidate > 1) {
                if(!pq.isEmpty() && pq.peek() > 1) {
                    max += candidate * pq.poll();
                } else {
                    max += candidate;
                }
            } else if (candidate == 1) {
                max += candidate;
            } else {
                negative.add(candidate);
            }
        }

        while(!negative.isEmpty()) {
            int candidate = negative.poll();

            if(negative.isEmpty()) {
                max += candidate;
            } else {
                max += candidate * negative.poll();
            }
        }

        System.out.println(max);
    }
}
