import java.io.*;
import java.util.*;

public class P24313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int fn1 = Integer.parseInt(st.nextToken());
        int fn2 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int result = 1;

        for(int i = n0; i <= 100; i++) {
            if((fn1 * i + fn2) > c * i ) {
                result = 0;
                break;
            }
        }

        System.out.println(result);
    }
}
