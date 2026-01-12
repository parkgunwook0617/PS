import java.io.*;
import java.util.*;

public class P1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        for(long x = start; x <= end; x++) {
            boolean isPrime = true;
            for(long y = 2; y * y <= x; y++) {
                if(x % y == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                if(x == 1) {
                    continue;
                } else {
                    System.out.println(x);
                }
            }
        }
    }
}
