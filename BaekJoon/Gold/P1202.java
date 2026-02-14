import java.io.*;
import java.util.*;

public class P1202 {
    public static class Jewel implements Comparable<Jewel> {
        long weight;
        long value;

        Jewel(long weight, long value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int jewelNumber = Integer.parseInt(st.nextToken());
        int bagNumber = Integer.parseInt(st.nextToken());

        Jewel[] jewelCollection = new Jewel[jewelNumber];
        long[] bagCollection = new long[bagNumber];

        for(int i = 0; i < jewelNumber; i++) {
            st = new StringTokenizer(br.readLine());
            long weight = Integer.parseInt(st.nextToken());
            long value = Integer.parseInt(st.nextToken());

            jewelCollection[i] = new Jewel(weight, value);
        }

        for(int i = 0; i < bagNumber; i++) {
            bagCollection[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());

        Arrays.sort(jewelCollection);
        Arrays.sort(bagCollection);

        long max = 0;
        int jewelIndex = 0;
        for (int i = 0; i < bagNumber; i++) {
            while (jewelIndex < jewelNumber && jewelCollection[jewelIndex].weight <= bagCollection[i]) {
                pq.add(jewelCollection[jewelIndex].value);
                jewelIndex++;
            }

            if (!pq.isEmpty()) {
                max += pq.poll();
            }
        }

        System.out.println(max);
    }
}
