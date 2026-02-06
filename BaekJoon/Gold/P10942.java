import java.io.*;
import java.util.*;

public class P10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] list = new int[size + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= size; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[size + 1][size + 1];
        for(int i = 1; i <= size; i++) {
            dp[i][i] = 1;
        }

        for(int i = 1; i < size; i++) {
            if(list[i] == list[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int gap = 2; gap < size; gap++) {
            for (int i = 1; i <= size - gap; i++) {
                int j = i + gap;
                if (list[i] == list[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        int questionNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < questionNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end]).append("\n");
        }

        System.out.println(sb);
    }
}
