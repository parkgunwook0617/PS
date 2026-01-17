import java.io.*;
import java.util.*;

public class P7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();

        int[][] table = new int[xSize][ySize];

        for(int x = 0; x < xSize; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
                if(table[x][y] == 1) {
                    q.add(new int[]{x, y});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int xPosition = position[0];
            int yPosition = position[1];

            if(xPosition - 1 >= 0) {
                if (table[xPosition - 1][yPosition] == 0) {
                    table[xPosition - 1][yPosition] = table[xPosition][yPosition] + 1;
                    q.add(new int[]{xPosition - 1, yPosition});
                }
            }

            if(xPosition + 1 < xSize) {
                if (table[xPosition + 1][yPosition] == 0) {
                    table[xPosition + 1][yPosition] = table[xPosition][yPosition] + 1;
                    q.add(new int[]{xPosition + 1, yPosition});
                }
            }

            if(yPosition - 1 >= 0) {
                if (table[xPosition][yPosition - 1] == 0) {
                    table[xPosition][yPosition - 1] = table[xPosition][yPosition] + 1;
                    q.add(new int[]{xPosition, yPosition - 1});
                }
            }

            if(yPosition + 1 < ySize) {
                if (table[xPosition][yPosition + 1] == 0) {
                    table[xPosition][yPosition + 1] = table[xPosition][yPosition] + 1;
                    q.add(new int[]{xPosition, yPosition + 1});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                if(table[x][y] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                if(table[x][y] > max) {
                    max = table[x][y];
                }
            }
        }

        System.out.println(max - 1);
    }
}
