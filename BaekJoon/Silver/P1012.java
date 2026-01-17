import java.io.*;
import java.util.*;

public class P1012 {
    public static int[][] table;
    public static int xSize;
    public static int ySize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCaseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ySize = Integer.parseInt(st.nextToken());
            xSize = Integer.parseInt(st.nextToken());
            int cabbageNumber = Integer.parseInt(st.nextToken());

            table = new int[xSize][ySize];

            for(int n = 0; n < cabbageNumber; n++) {
                st = new StringTokenizer(br.readLine());
                int yPosition = Integer.parseInt(st.nextToken());
                int xPosition = Integer.parseInt(st.nextToken());

                table[xPosition][yPosition] = 1;
            }

            int count = 0;

            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(table[x][y] == 1) {
                        DFS(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    public static void DFS(int x, int y) {
        table[x][y] = 0;

        if(x + 1 < xSize) {
            if(table[x + 1][y] == 1) {
                DFS(x + 1, y);
            }
        }

        if(x - 1 >= 0) {
            if(table[x - 1][y] == 1) {
                DFS(x - 1, y);
            }
        }

        if(y + 1 < ySize) {
            if(table[x][y + 1] == 1) {
                DFS(x, y + 1);
            }
        }

        if(y - 1 >= 0) {
            if(table[x][y - 1] == 1) {
                DFS(x, y - 1);
            }
        }
    }
}
