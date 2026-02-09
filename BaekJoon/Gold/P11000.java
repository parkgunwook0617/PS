import java.io.*;
import java.util.*;

public class P11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] list = new int[size][2];
        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        pq.add(list[0]);
        for(int i = 1; i < size; i++) {
            if(!pq.isEmpty()) {
                if(pq.peek()[1] <= list[i][0]) {
                    int[] nextClass = pq.poll();
                    nextClass[1] = list[i][1];
                    pq.add(nextClass);
                } else {
                    pq.add(list[i]);
                }
            }
        }

        System.out.println(pq.size());
    }
}
