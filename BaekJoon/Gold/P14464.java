import java.io.*;
import java.util.*;

public class P14464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int chickenNumber = Integer.parseInt(st.nextToken());
        int cowNumber = Integer.parseInt(st.nextToken());

        long[] chicken = new long[chickenNumber];
        for(int i = 0; i < chickenNumber; i++) {
            chicken[i] = Long.parseLong(br.readLine());
        }

        long[][] cowTime = new long[cowNumber][2];
        for(int i = 0; i < cowNumber; i++) {
            st = new StringTokenizer(br.readLine());
            long startTime = Long.parseLong(st.nextToken());
            long endTime = Long.parseLong(st.nextToken());

            cowTime[i][0] = startTime;
            cowTime[i][1] = endTime;
        }

        Arrays.sort(cowTime, (o1, o2) -> {
           if(o1[1] == o2[1]) {
               return Long.compare(o2[0], o1[0]);
           }

           return Long.compare(o1[1], o2[1]);
        });

        TreeMap<Long, Integer> chickenMap = new TreeMap<>();
        for (long t : chicken) {
            chickenMap.put(t, chickenMap.getOrDefault(t, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < cowNumber; i++) {
            long start = cowTime[i][0];
            long end = cowTime[i][1];

            Long bestChicken = chickenMap.ceilingKey(start);

            if (bestChicken != null && bestChicken <= end) {
                count++;

                int val = chickenMap.get(bestChicken);

                if (val == 1) {
                    chickenMap.remove(bestChicken);
                }
                else {
                    chickenMap.put(bestChicken, val - 1);
                }
            }
        }

        System.out.println(count);
    }
}
