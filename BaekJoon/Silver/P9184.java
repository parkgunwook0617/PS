import java.io.*;
import java.util.*;

public class P9184 {
    public static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) {
                break;
            }

            recursionFunction(a, b, c);
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, recursionFunction(a, b, c));
        }
    }

    public static int recursionFunction(int a, int b, int c) {
        if( a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {
            return recursionFunction(20, 20, 20);
        }

        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            return dp[a][b][c] = recursionFunction(a, b, c - 1) + recursionFunction(a, b - 1, c - 1) - recursionFunction(a, b - 1, c);
        }

        return dp[a][b][c] = recursionFunction(a - 1, b, c) + recursionFunction(a - 1, b - 1, c) + recursionFunction(a - 1, b, c - 1) - recursionFunction(a - 1, b - 1, c - 1);
    }
}
