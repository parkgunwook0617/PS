import java.io.*;
import java.util.*;

public class P2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] lines = new int[size][2];
        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines[i][0] = Math.min(x, y);
            lines[i][1] = Math.max(x, y);
        }

        Arrays.sort(lines, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int totalLength = 0;
        int currentStart = lines[0][0];
        int currentEnd = lines[0][1];

        for(int i = 1; i < size; i++) {
            if(lines[i][0] <= currentEnd) {
                currentEnd = Math.max(currentEnd, lines[i][1]);
            } else {
                totalLength += currentEnd - currentStart;
                currentStart = lines[i][0];
                currentEnd = lines[i][1];
            }
        }

        totalLength += currentEnd - currentStart;

        System.out.println(totalLength);
    }
}