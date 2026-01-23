import java.io.*;
import java.util.*;

public class P1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lineNumber = Integer.parseInt(st.nextToken());
        int needLine = Integer.parseInt(st.nextToken());
        int[] lines = new int[lineNumber];

        for(int i = 0; i < lineNumber; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);

        long length = 0;
        long left = 1;
        long right = lines[lineNumber - 1];
        while(left <= right) {
            long madeLine = 0;
            long mid = (left + right) / 2;
            for(int i = 0; i < lineNumber; i++) {
                madeLine += lines[i] / mid;
            }

            if(madeLine >= needLine) {
                length = mid;
                left = mid + 1;
            } else if (madeLine < needLine) {
                right = mid - 1;
            }
        }

        System.out.println(length);
    }
}
