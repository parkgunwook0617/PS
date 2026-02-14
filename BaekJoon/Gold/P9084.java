import java.io.*;
import java.util.*;

public class P9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseNumber = Integer.parseInt(br.readLine());

        while(testcaseNumber != 0) {
            int coinNumber = Integer.parseInt(br.readLine());
            int[] coin = new int[coinNumber];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < coinNumber; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int targetMoney = Integer.parseInt(br.readLine());

            int[] dp = new int[targetMoney + 1];

            dp[0] = 1;

            for (int currentCoin : coin) {
                for (int i = currentCoin; i <= targetMoney; i++) {
                    dp[i] += dp[i - currentCoin];
                }
            }

            System.out.println(dp[targetMoney]);

            testcaseNumber--;
        }
    }
}
