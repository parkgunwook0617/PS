import java.io.*;
import java.util.*;

public class P2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int k = 0; k < size; k++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        int result = 0;
        for(int i = 0; i < size; i++) {
            result = pq.poll();
        }

        System.out.println(result);
    }
}
