import java.io.*;
import java.util.*;

public class P1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetNumber = Integer.parseInt(st.nextToken());
        int cityNumber = Integer.parseInt(st.nextToken());
        int[][] cityInformation = new int[cityNumber][2];

        for (int i = 0; i < cityNumber; i++) {
            st = new StringTokenizer(br.readLine());

            cityInformation[i][0] = Integer.parseInt(st.nextToken());
            cityInformation[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1000 * 100 + 1];
        Arrays.fill(dp, -1);

        for (int i = 0; i < cityNumber; i++) {
            dp[cityInformation[i][0]] = Math.max(dp[cityInformation[i][0]], cityInformation[i][1]);
        }

        for (int i = 0; i <= 1000 * 100; i++) {
            for (int k = 0; k < cityNumber; k++) {
                int candidateCityCost = cityInformation[k][0];
                int candidateCityReturn = cityInformation[k][1];

                if (i - candidateCityCost < 0) {
                    continue;
                }

                dp[i] = Math.max(dp[i], dp[i - candidateCityCost] + candidateCityReturn);
            }
        }

        for (int i = 0; i <= 1000 * 100; i++) {
            if (dp[i] >= targetNumber) {
                System.out.println(i);
                return;
            }
        }
    }
}
