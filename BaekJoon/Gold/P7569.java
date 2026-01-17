import java.io.*;
import java.util.*;

public class P7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        int[][][] table = new int[height][xSize][ySize];

        for(int z = 0; z < height; z++) {
            for(int x = 0; x < xSize; x++) {
                st = new StringTokenizer(br.readLine());

                for(int y = 0; y < ySize; y++) {
                    table[z][x][y] = Integer.parseInt(st.nextToken());
                    if(table[z][x][y] == 1) {
                        q.add(new int[]{z, x, y});
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int zPosition = position[0];
            int xPosition = position[1];
            int yPosition = position[2];

            if(xPosition + 1 < xSize) {
                if(table[zPosition][xPosition + 1][yPosition] == 0) {
                    table[zPosition][xPosition + 1][yPosition] = table[zPosition][xPosition][yPosition] + 1;
                    q.add(new int[]{zPosition, xPosition + 1, yPosition});
                }
            }

            if(xPosition - 1 >= 0) {
                if(table[zPosition][xPosition - 1][yPosition] == 0) {
                    table[zPosition][xPosition - 1][yPosition] = table[zPosition][xPosition][yPosition] + 1;
                    q.add(new int[]{zPosition, xPosition - 1, yPosition});
                }
            }

            if(yPosition + 1 < ySize) {
                if(table[zPosition][xPosition][yPosition + 1] == 0) {
                    table[zPosition][xPosition][yPosition + 1] = table[zPosition][xPosition][yPosition] + 1;
                    q.add(new int[]{zPosition, xPosition, yPosition + 1});
                }
            }

            if(yPosition - 1 >= 0) {
                if(table[zPosition][xPosition][yPosition - 1] == 0) {
                    table[zPosition][xPosition][yPosition - 1] = table[zPosition][xPosition][yPosition] + 1;
                    q.add(new int[]{zPosition, xPosition, yPosition - 1});
                }
            }

            if(zPosition + 1 < height) {
                if(table[zPosition + 1][xPosition][yPosition] == 0) {
                    table[zPosition + 1][xPosition][yPosition] = table[zPosition][xPosition][yPosition] + 1;
                    q.add(new int[]{zPosition + 1, xPosition, yPosition});
                }
            }

            if(zPosition - 1 >= 0) {
                if(table[zPosition - 1][xPosition][yPosition] == 0) {
                    table[zPosition - 1][xPosition][yPosition] = table[zPosition][xPosition][yPosition] + 1;
                    q.add(new int[]{zPosition - 1, xPosition, yPosition});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int z = 0; z < height; z++) {
            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(table[z][x][y] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }

                    if(table[z][x][y] > max) {
                        max = table[z][x][y];
                    }
                }
            }
        }

        System.out.println(max - 1);
    }
}
