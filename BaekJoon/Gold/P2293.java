import java.io.*;
import java.util.*;

public class P2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coinNumber = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] coin = new int[coinNumber];
        for(int i = 0; i < coinNumber; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < coinNumber; i++) {
            for(int k = coin[i]; k<= target; k++) {
                dp[k] = dp[k] + dp[k - coin[i]];
            }
        }

        System.out.println(dp[target]);
    }
}
