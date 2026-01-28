import java.io.*;
import java.util.*;

public class P12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] tryNumberTable = new int[number + 1];
        String[] tryOrderTable = new String[number + 1];

        Arrays.fill(tryNumberTable, Integer.MAX_VALUE);

        tryNumberTable[1] = 0;
        tryOrderTable[1] = "1";
        if(number == 1) {
            System.out.println(tryNumberTable[1]);
            System.out.println(tryOrderTable[1]);
            System.exit(0);
        }
        tryNumberTable[2] = 1;
        tryOrderTable[2] = "2 1";
        for(int i = 3; i <= number; i++) {

            if(i % 3 == 0) {
                if(tryNumberTable[i / 3] + 1 < tryNumberTable[i]) {
                    tryNumberTable[i] = Math.min(tryNumberTable[i / 3] + 1, tryNumberTable[i]);
                    tryOrderTable[i] = String.valueOf(i) + " " + tryOrderTable[i / 3];
                }
            }

            if(i % 2 == 0) {
                if(tryNumberTable[i / 2] + 1 < tryNumberTable[i]) {
                    tryNumberTable[i] = Math.min(tryNumberTable[i / 2] + 1, tryNumberTable[i]);
                    tryOrderTable[i] = String.valueOf(i) + " " + tryOrderTable[i / 2];
                }
            }

            if(tryNumberTable[i - 1] + 1 < tryNumberTable[i]) {
                tryNumberTable[i] = Math.min(tryNumberTable[i - 1] + 1, tryNumberTable[i]);
                tryOrderTable[i] = String.valueOf(i) + " " + tryOrderTable[i - 1];
            }
        }

        System.out.println(tryNumberTable[number]);
        System.out.println(tryOrderTable[number]);
    }
}
