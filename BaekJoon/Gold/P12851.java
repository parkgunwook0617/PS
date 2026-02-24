import java.io.*;
import java.util.*;

public class P12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<List<Integer>> collection = new ArrayList<>();
        for(int i = 0; i <= 100000; i++) {
            collection.add(new ArrayList<>());
            if(i >= 1 && i <= 50000) {
                collection.get(i).add(i - 1);
                collection.get(i).add(i + 1);
                collection.get(i).add(2 * i);
            } else if (i >= 50001) {
                collection.get(i).add(i - 1);
                collection.get(i).add(i + 1);
            } else {
                collection.get(i).add(i + 1);
            }
        }

        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());
        int count = 0;
        int minTime = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startPos, 0});

        int[] time = new int[100001];
        Arrays.fill(time, -1);
        time[startPos] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int now = curr[0];
            int t = curr[1];

            if(now == endPos) {
                if(minTime > t) {
                    minTime = t;
                    count = 1;
                } else if (minTime == t) {
                    count++;
                }

                continue;
            }

            int[] nexts = {now - 1, now + 1, now * 2};
            for (int next : nexts) {
                if (next < 0 || next > 100000) {
                    continue;
                }

                if (time[next] == -1 || time[next] == t + 1) {
                    time[next] = t + 1;
                    q.add(new int[]{next, t + 1});
                }
            }
        }

        System.out.println(time[endPos]);
        System.out.println(count);
    }
}
