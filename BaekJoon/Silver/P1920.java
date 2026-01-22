import java.io.*;
import java.util.*;

public class P1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberSetNumber = Integer.parseInt(br.readLine());
        int[] numberSet = new int[numberSetNumber];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numberSetNumber; i++) {
            numberSet[i] = Integer.parseInt(st.nextToken());
        }
        int testNumberSetNumber = Integer.parseInt(br.readLine());
        int[] testNumberSet = new int[testNumberSetNumber];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < testNumberSetNumber; i++) {
            testNumberSet[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numberSet);

        for(int i = 0; i < testNumberSetNumber; i++) {
            int left = 0;
            int right = numberSetNumber - 1;
            int targetNumber = testNumberSet[i];
            boolean isIn = false;
            while(left <= right) {
                int mid = (left + right) / 2;

                if(numberSet[mid] == targetNumber) {
                    isIn = true;
                    break;
                } else if(numberSet[mid] > targetNumber) {
                    right = mid - 1;
                } else if (numberSet[mid] < targetNumber) {
                    left = mid + 1;
                }
            }

            if(isIn) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
