import java.io.*;
import java.util.*;

public class P1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long number = Long.parseLong(st.nextToken());
        long power = Long.parseLong(st.nextToken());
        long divider = Long.parseLong(st.nextToken());

        System.out.println(pow(number, power, divider));
    }

    public static long pow(long number, long power, long divider) {
        if(power == 0) {
            return 1;
        }

        long temp = pow(number, power / 2, divider);

        if(power % 2 == 0) {
            return (temp * temp) % divider;
        } else {
            return ((temp * temp) % divider * (number) % divider) % divider;
        }
    }
}
