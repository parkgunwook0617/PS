import java.io.*;
import java.util.*;

public class P7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testcaseNumber != 0) {
            int commandNumber = Integer.parseInt(br.readLine());
            PriorityQueue<Long> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            HashMap<Long, Integer> map = new HashMap<>();

            for(int i = 0; i < commandNumber; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                long number = Long.parseLong(st.nextToken());

                if(command == 'I') {
                    maxHeap.add(number);
                    minHeap.add(number);
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else if (command == 'D') {
                    long data;
                    if(number == -1) {
                        while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
                            minHeap.poll();
                        }

                        if (!minHeap.isEmpty()) {
                            long target = minHeap.poll();
                            map.put(target, map.get(target) - 1);
                        }
                    } else {
                        while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
                            maxHeap.poll();
                        }

                        if (!maxHeap.isEmpty()) {
                            long target = maxHeap.poll();
                            map.put(target, map.get(target) - 1);
                        }
                    }
                }
            }

            while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
                maxHeap.poll();
            }

            while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
                minHeap.poll();
            }

            if(maxHeap.isEmpty() || minHeap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
            }

            testcaseNumber--;
        }

        System.out.println(sb);
    }
}
