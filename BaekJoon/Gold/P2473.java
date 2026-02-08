import java.io.*;
import java.util.*;

public class P2473 {
    public static long result = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        long[] list = new long[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(list);

        long[] resultCollection = new long[3];
        for(int left = 0; left < size - 2; left++) {
            int middle = left + 1;
            int right = size - 1;

            while(middle < right) {
                long sum = list[left] + list[middle] + list[right];

                if(result >= Math.abs(sum)) {
                    result = Math.abs(sum);
                    resultCollection[0] = list[left];
                    resultCollection[1] = list[middle];
                    resultCollection[2] = list[right];

                    if(sum == 0) {
                        System.out.println(resultCollection[0] + " " + resultCollection[1] + " " + resultCollection[2]);
                        return;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        middle++;
                    }
                } else {
                    if (sum > 0) {
                        right--;
                    } else {
                        middle++;
                    }
                }
            }
        }

        System.out.println(resultCollection[0] + " " + resultCollection[1] + " " + resultCollection[2]);
    }
}
