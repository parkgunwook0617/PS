import java.io.*;
import java.util.*;

public class P2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetNumber = Integer.parseInt(br.readLine());
        int list1Size = Integer.parseInt(br.readLine());

        int[] list1 = new int[list1Size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < list1Size; i++) {
            list1[i] = Integer.parseInt(st.nextToken());
        }

        int list2Size = Integer.parseInt(br.readLine());

        int[] list2 = new int[list2Size];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < list2Size; i++) {
            list2[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sumA = new ArrayList<>();
        for (int i = 0; i < list1Size; i++) {
            int currentSum = 0;

            for (int k = i; k < list1Size; k++) {
                currentSum += list1[k];
                sumA.add(currentSum);
            }
        }

        List<Integer> sumB = new ArrayList<>();
        for (int i = 0; i < list2Size; i++) {
            int currentSum = 0;

            for (int k = i; k < list2Size; k++) {
                currentSum += list2[k];
                sumB.add(currentSum);
            }
        }

        sumA.sort(Comparator.naturalOrder());
        sumB.sort(Comparator.naturalOrder());

        int left = 0;
        int right = sumB.size() - 1;
        long result = 0;

        while(left < sumA.size() && right >= 0) {
            int sum = sumA.get(left) + sumB.get(right);

            if(sum < targetNumber) {
                left++;
            } else if (sum > targetNumber ){
                right--;
            } else if (sum == targetNumber) {
                int leftElement = sumA.get(left);
                int rightElement = sumB.get(right);

                long countLeft = 0;
                long countRight = 0;

                while (left < sumA.size() && sumA.get(left) == leftElement) {
                    countLeft++;
                    left++;
                }

                while (right >= 0 && sumB.get(right) == rightElement) {
                    countRight++;
                    right--;
                }

                result += countLeft * countRight;
            }
        }

        System.out.println(result);
    }
}
