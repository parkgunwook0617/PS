import java.io.*;
import java.util.*;

public class P13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());
        while(testcaseNumber != 0) {
            int number = Integer.parseInt(br.readLine());

            PriorityQueue<Long> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < number; i++) {
                minHeap.add(Long.parseLong(st.nextToken()));
            }

            long min = 0;

            while(minHeap.size() >= 2) {
                long min1 = minHeap.poll();
                long min2 = minHeap.poll();

                long sum = min1 + min2;
                min += sum;
                minHeap.add(sum);
            }

            System.out.println(min);

            testcaseNumber--;
        }
    }
}
