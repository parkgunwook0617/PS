import java.io.*;
import java.util.*;

public class P1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetNumber = Integer.parseInt(br.readLine());

        boolean[] primeList = new boolean[targetNumber + 1];
        Arrays.fill(primeList, true);
        primeList[0] = false;
        primeList[1] = false;
        for(int i = 2; i <= Math.sqrt(targetNumber); i++) {
            for(int k = 2; i * k <= targetNumber; k++) {
                primeList[i * k] = false;
            }
        }

        List<Integer> primeCollection = new ArrayList<>();
        for(int i = 0; i <= targetNumber; i++) {
            if(primeList[i]) {
                primeCollection.add(i);
            }
        }

        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < primeCollection.size()) {
            sum += primeCollection.get(right);

            if(sum < targetNumber) {
                right++;
            } else if (sum > targetNumber) {
                sum -= primeCollection.get(left);
                sum -= primeCollection.get(right);
                left++;
            } else if (sum == targetNumber) {
                count++;
                right++;
            }
        }

        System.out.println(count);
    }
}
