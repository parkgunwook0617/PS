import java.io.*;
import java.util.*;

public class P14888 {
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());
        long[] number = new long[numberCount];
        long[] arithmetic = new long[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numberCount; i++) {
            number[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            arithmetic[i] = Long.parseLong(st.nextToken());
        }

        long value = number[0];
        simulation(number, arithmetic, 0, value);

        System.out.println(max);
        System.out.println(min);
    }

    public static void simulation(long[] number, long[] arithmetic, int pos, long value) {
        if(pos == number.length - 1) {
            if(value > max) {
                max = value;
            }

            if(value < min) {
                min = value;
            }

            return;
        }

        if(arithmetic[0] != 0) {
            arithmetic[0]--;
            simulation(number, arithmetic, pos + 1, value + number[pos + 1]);
            arithmetic[0]++;
        }

        if (arithmetic[1] != 0) {
            arithmetic[1]--;
            simulation(number, arithmetic, pos + 1, value - number[pos + 1]);
            arithmetic[1]++;
        }

        if (arithmetic[2] != 0) {
            arithmetic[2]--;
            simulation(number, arithmetic, pos + 1, value * number[pos + 1]);
            arithmetic[2]++;
        }

        if (arithmetic[3] != 0) {
            arithmetic[3]--;
            simulation(number, arithmetic, pos + 1, value / number[pos + 1]);
            arithmetic[3]++;
        }
    }
}
