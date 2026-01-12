import java.io.*;
import java.util.*;

public class P1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] element1 = new long[2];
        element1[0] = Long.parseLong(st.nextToken());
        element1[1] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] element2 = new long[2];
        element2[0] = Long.parseLong(st.nextToken());
        element2[1] = Long.parseLong(st.nextToken());

        long[] middleElement = element2.clone();

        element2[0] = element2[0] * element1[1];
        element2[1] = element2[1] * element1[1];

        element1[0] = element1[0] * middleElement[1];
        element1[1] = element1[1] * middleElement[1];

        long[] finalElement = new long[2];
        finalElement[0] = element1[0] + element2[0];
        finalElement[1] = element1[1];

        long gcd = getGCD(finalElement[0], finalElement[1]);
        finalElement[0] /= gcd;
        finalElement[1] /= gcd;

        System.out.println(finalElement[0] + " " + finalElement[1]);
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
