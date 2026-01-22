import java.io.*;
import java.util.*;

public class P11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardNumber = Integer.parseInt(br.readLine());
        int[] cardSet = new int[cardNumber + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= cardNumber; i++) {
            cardSet[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[cardNumber + 1];

        for(int i = 1; i <= cardNumber; i++) {
            dp[i] = cardSet[i];
        }

        for(int i = 2; i <= cardNumber; i++) {
            for(int k = 1; k < i; k++) {
                dp[i] = Math.max(dp[i], dp[i - k] + cardSet[k]);
            }
        }

        System.out.println(dp[cardNumber]);
    }
}
