import java.io.*;
import java.util.*;

public class P2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] numberList = new int[number];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < number; i++) {
            numberList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numberList);
        int start = 0;
        int end = number - 1;
        int[] targetList = new int[2];
        int minSum = Integer.MAX_VALUE;

        while(start < end) {
            int sum = numberList[start] + numberList[end];

            if(sum >= 0) {
                if(Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    targetList[0] = numberList[start];
                    targetList[1] = numberList[end];
                } else {
                    end--;
                }
            } else if (sum < 0) {
                if(Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    targetList[0] = numberList[start];
                    targetList[1] = numberList[end];
                } else {
                    start++;
                }
            }
        }

        System.out.print(targetList[0] + " " + targetList[1]);
    }
}
