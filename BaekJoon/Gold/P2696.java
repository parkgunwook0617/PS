import java.io.*;
import java.util.*;

public class P2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());

        while(testcaseNumber != 0) {
            int size = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            int count = 1;

            for(int x = 0; x <= size / 10; x++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int y = 1; y <= 10; y++) {
                    if(10 * x + y > size) {
                        break;
                    }

                    int nextValue = Integer.parseInt(st.nextToken());

                    if(x == 0 && y == 1) {
                        maxHeap.add(nextValue);
                        System.out.println(size / 2 + 1);
                    } else {
                        if(maxHeap.size() == minHeap.size()) {
                            maxHeap.add(nextValue);
                        } else {
                            minHeap.add(nextValue);
                        }
                    }

                    if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                        if (maxHeap.peek() > minHeap.peek()) {
                            int tmp1 = maxHeap.poll();
                            int tmp2 = minHeap.poll();
                            maxHeap.add(tmp2);
                            minHeap.add(tmp1);
                        }
                    }

                    if(count % 2 == 1) {
                        System.out.print(maxHeap.peek() + " ");
                    }

                    count++;
                }
            }

            System.out.println();

            testcaseNumber--;
        }
    }
}
