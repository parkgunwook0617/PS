import java.io.*;
import java.util.*;

public class P14502 {
    public static int maxSafeAreaNumber = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        int[][] table = new int[xSize][ySize];

        for(int x = 0; x < xSize; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                if(table[x][y] == 0) {
                    simulation(table, xSize, ySize, 0, x, y);
                }
            }
        }

        System.out.println(maxSafeAreaNumber);
    }

    public static void simulation(int[][] table, int xSize, int ySize, int wallNumber, int currentX, int currentY) {
        if(wallNumber == 3) {
            int[][] dummyTable = new int[xSize][ySize];
            for(int i = 0; i < xSize; i++) {
                dummyTable[i] = table[i].clone();
            }

            Queue<int[]> index = new LinkedList<>();
            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(dummyTable[x][y] == 2) {
                        index.add(new int[]{x, y});
                    }
                }
            }

            while(!index.isEmpty()) {
                int[] position = index.poll();
                int xPos = position[0];
                int yPos = position[1];
                if(xPos + 1 < xSize) {
                    if(dummyTable[xPos + 1][yPos] == 0) {
                        dummyTable[xPos + 1][yPos] = 2;
                        index.add(new int[]{xPos + 1, yPos});
                    }
                }

                if(yPos + 1 < ySize) {
                    if(dummyTable[xPos][yPos + 1] == 0) {
                        dummyTable[xPos][yPos + 1] = 2;
                        index.add(new int[]{xPos, yPos + 1});
                    }
                }

                if(xPos - 1 >= 0) {
                    if(dummyTable[xPos - 1][yPos] == 0) {
                        dummyTable[xPos - 1][yPos] = 2;
                        index.add(new int[]{xPos - 1, yPos});
                    }
                }

                if(yPos - 1 >= 0) {
                    if(dummyTable[xPos][yPos - 1] == 0) {
                        dummyTable[xPos][yPos - 1] = 2;
                        index.add(new int[]{xPos, yPos - 1});
                    }
                }
            }

            int safeAreaNumber = 0;
            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(dummyTable[x][y] == 0) {
                        safeAreaNumber++;
                    }
                }
            }

            if(maxSafeAreaNumber < safeAreaNumber) {
                maxSafeAreaNumber = safeAreaNumber;
            }

            return;
        }

        for(int x = currentX; x < xSize; x++) {
            int startY = (x == currentX) ? currentY : 0;

            for(int y = startY; y < ySize; y++) {
                if(table[x][y] == 0) {
                    table[x][y] = 1;
                    if(y == ySize - 1) {
                        simulation(table, xSize, ySize, wallNumber + 1, x + 1, 0);
                    } else {
                        simulation(table, xSize, ySize, wallNumber + 1, x, y + 1);
                    }
                    table[x][y] = 0;
                }
            }
        }
    }
}
