import java.io.*;
import java.util.*;

public class P1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String targetNumber = br.readLine();
        int[] targetNumberArray = new int[targetNumber.length()];

        for(int i = 0; i < targetNumber.length(); i++) {
            targetNumberArray[i] =  targetNumber.charAt(i) - 48;
        }

        Arrays.sort(targetNumberArray);

        for(int i = targetNumber.length() - 1; i >= 0; i--) {
            System.out.print(targetNumberArray[i]);
        }
    }
}
