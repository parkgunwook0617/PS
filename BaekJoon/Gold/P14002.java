import java.io.*;
import java.util.*;

public class P14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] numberList = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            numberList[i] = Integer.parseInt(st.nextToken());
        }

        int[] lisNumber = new int[size];
        String[] lisList = new String[size];

        Arrays.fill(lisNumber, 1);
        for(int i = 0; i < size; i++) {
            lisList[i] = String.valueOf(numberList[i]);
        }

        for(int i = 1; i < size; i++) {
            for(int k = 0; k < i; k++) {
                if(numberList[i] > numberList[k]) {
                    if(lisNumber[i] < lisNumber[k] + 1) {
                        lisNumber[i] = Math.max(lisNumber[i], lisNumber[k] + 1);
                        lisList[i] = lisList[k] + " " + numberList[i];
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < size; i++) {
            if(max < lisNumber[i]) {
                index = i;
                max = lisNumber[i];
            }
        }

        System.out.println(max);
        System.out.println(lisList[index]);
    }
}
