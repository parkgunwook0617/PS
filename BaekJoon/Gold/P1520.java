import java.io.*;
import java.util.*;

public class P1520 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        int[][] table = new int[xSize][ySize];
        int[][] dp = new int[xSize][ySize];

        for(int x = 0; x < xSize; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < xSize; i++) {
            Arrays.fill(dp[i], -1);
        }

        int route = DFS(table, dp, xSize, ySize, 0, 0);

        System.out.println(route);
    }

    public static int DFS(int[][] table, int[][] dp, int xSize, int ySize, int xPos, int yPos) {
        if (dp[xPos][yPos] != -1) {
            return dp[xPos][yPos];
        }

        if(xPos == xSize - 1 && yPos == ySize - 1) {
            return 1;
        }

        int route = 0;

        if(xPos + 1 < xSize) {
            if(table[xPos + 1][yPos] < table[xPos][yPos]) {
                route += DFS(table, dp, xSize, ySize, xPos + 1, yPos);
            }
        }

        if(xPos - 1 >= 0) {
            if(table[xPos - 1][yPos] < table[xPos][yPos]) {
                route += DFS(table, dp, xSize, ySize, xPos - 1, yPos);
            }
        }

        if(yPos + 1 < ySize) {
            if(table[xPos][yPos + 1] < table[xPos][yPos]) {
                route += DFS(table, dp, xSize, ySize, xPos, yPos + 1);
            }
        }

        if(yPos - 1 >= 0) {
            if(table[xPos][yPos - 1] < table[xPos][yPos]) {
                route += DFS(table, dp, xSize, ySize, xPos, yPos - 1);
            }
        }

        return dp[xPos][yPos] = route;
    }
}
