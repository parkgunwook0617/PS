import java.io.*;
import java.util.*;

public class P1019 {
    public static long[] counter = new long[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pageNumber = Integer.parseInt(br.readLine());

        int start = 1;
        int end = pageNumber;
        int point = 1;
        while(start <= end) {
            while (start % 10 != 0 && start <= end) {
                count(start, point);
                start++;
            }

            if (start > end) {
                break;
            }

            while (end % 10 != 9 && start <= end) {
                count(end, point);
                end--;
            }

            long diff = (end / 10 - start / 10 + 1);
            for (int i = 0; i < 10; i++) {
                counter[i] += diff * point;
            }

            start /= 10;
            end /= 10;
            point *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            sb.append(counter[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void count(int num, long point) {
        while (num > 0) {
            counter[num % 10] += point;
            num /= 10;
        }
    }
}
