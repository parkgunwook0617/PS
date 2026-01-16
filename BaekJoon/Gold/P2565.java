import java.io.*;
import java.util.*;

public class P2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberCount = Integer.parseInt(br.readLine());
        int[][] jungitjul = new int[numberCount][2];
        for(int i = 0; i < numberCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            jungitjul[i][0] = Integer.parseInt(st.nextToken());
            jungitjul[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jungitjul, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int[] dp = new int[numberCount];

        for(int i = 0; i < numberCount; i++) {
            dp[i] = 1;
        }

        for(int i = 0; i < numberCount; i++) {
            for(int j = 0; j < i; j++) {
                if(jungitjul[j][1] < jungitjul[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < numberCount; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(numberCount - max);
    }
}
