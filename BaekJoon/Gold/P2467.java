import java.io.*;
import java.util.*;

public class P2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] list = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int left = 0;
        int right = size - 1;
        int traitValue = Integer.MAX_VALUE;
        int[] targetValues = new int[2];
        while(left < right) {
            int sum = list[left] + list[right];

            if(Math.abs(sum) <= traitValue) {
                traitValue = Math.abs(sum);
                targetValues[0] = list[left];
                targetValues[1] = list[right];

                if(sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else if (sum == 0) {
                    System.out.println(targetValues[0] + " " + targetValues[1]);
                    return;
                }
            }  else {
                if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(targetValues[0] + " " + targetValues[1]);
    }
}
