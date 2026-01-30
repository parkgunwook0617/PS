import java.io.*;
import java.util.*;

public class P11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNumber = Integer.parseInt(br.readLine());
        int busNumber = Integer.parseInt(br.readLine());

        long[][] table = new long[cityNumber + 1][cityNumber + 1];
        for (int i = 0; i <= cityNumber; i++) {
            Arrays.fill(table[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < busNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            table[start][end] = Math.min(table[start][end], weight);
        }

        for(int i = 1; i <= cityNumber; i++) {
            table[i][i] = 0;
        }

        for(int salt = 1; salt <= cityNumber; salt++) {
            for(int x = 1; x <= cityNumber; x++) {
                for(int y = 1; y <= cityNumber; y++) {
                    if(table[x][salt] + table[salt][y] < table[x][y]) {
                        table[x][y] = table[x][salt] + table[salt][y];
                    }
                }
            }
        }

        for(int x = 1; x <= cityNumber; x++) {
            for(int y = 1; y <= cityNumber; y++) {
                if(table[x][y] == Integer.MAX_VALUE) {
                    table[x][y] = 0;
                }
                System.out.print(table[x][y] + " ");
            }

            System.out.println();
        }
    }
}
