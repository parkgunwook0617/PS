import java.io.*;
import java.util.*;

public class P2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        long[] treePosition = new long[count];

        for(int i = 0; i < count; i++) {
            treePosition[i] = Long.parseLong(br.readLine());
        }

        long[] relativePosition = new long[count - 1];
        long gcd = treePosition[1] - treePosition[0];
        for(int i = 0; i < count - 1; i ++) {
            relativePosition[i] = treePosition[i + 1] - treePosition[i];
            gcd = getGCD(gcd, relativePosition[i]);
        }

        int neededTree = 0;
        int index = 0;
        for(long i = treePosition[0]; i < treePosition[count-1]; i += gcd) {
            if(treePosition[index] == i) {
                index++;
            } else {
                neededTree++;
            }
        }

        System.out.println(neededTree);
    }

    public static long getGCD(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
