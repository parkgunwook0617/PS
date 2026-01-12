import java.io.*;
import java.util.*;

public class P17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean[] isNotPrime = new boolean[1000001];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!isNotPrime[i]) {
                for (int j = 2 * i; j <= 1000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for(int i = 0 ; i < count; i++) {
            int number = Integer.parseInt(br.readLine());
            int goldCount = 0;
            for(int x = 2; x <= number / 2; x++) {
                int y = number - x;

                if(!isNotPrime[x] && !isNotPrime[y]) {
                    goldCount++;
                }
            }

            sb.append(goldCount).append("\n");
        }

        System.out.println(sb);
    }
}
