import java.io.*;
import java.util.*;

public class P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] numberList = new int[number];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < number; i++) {
            numberList[i] = Integer.parseInt(st.nextToken());
        }

        int targetNumber = Integer.parseInt(br.readLine());

        Arrays.sort(numberList);

        int start = 0;
        int end = number - 1;
        int count = 0;

        while (start < end) {
            int sum = numberList[start] + numberList[end];

            if (sum == targetNumber) {
                count++;
                start++;
                end--;
            } else if (sum < targetNumber) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count);
    }
}
