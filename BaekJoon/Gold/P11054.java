import java.io.*;
import java.util.*;

public class P11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());
        int[] numArray = new int[numberCount + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= numberCount; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        int[] startToEnd = new int[numberCount + 2];
        int[] endToStart = new int[numberCount + 2];

        for(int x = 1; x <= numberCount + 1; x++) {
            startToEnd[x] = 1;

            for(int y = 0; y < x; y++) {
                if(numArray[x] > numArray[y]) {
                    startToEnd[x] = Math.max(startToEnd[x], startToEnd[y] + 1);
                }
            }
        }

        startToEnd[numberCount + 1] = 0;

        for(int x = numberCount; x >= 1; x--) {
            endToStart[x] = 1;

            for(int y = numberCount + 1; y > x; y--) {
                if(numArray[x] > numArray[y]) {
                    endToStart[x] = Math.max(endToStart[x], endToStart[y] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 1; i < numberCount + 2; i++) {
            max = Math.max(max, startToEnd[i] + endToStart[i]);
        }

        System.out.println(max - 1);
    }
}
