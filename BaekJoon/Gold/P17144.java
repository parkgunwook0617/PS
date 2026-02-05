import java.io.*;
import java.util.*;

public class P17144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int[][] table = new int[xSize][ySize];
        for(int x = 0; x < xSize; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int[] upper = new int[2];
        Arrays.fill(upper, -1);
        int[] lower = new int[2];
        Arrays.fill(lower, -1);

        for(int i = 0; i < time; i++) {
            int[][] nextTable = new int[xSize][ySize];

            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(table[x][y] == -1) {
                        nextTable[x][y] = -1;

                        if(upper[0] == -1 && upper[1] == -1) {
                            upper[0] = x;
                            upper[1] = y;
                        } else {
                            lower[0] = x;
                            lower[1] = y;
                        }

                        continue;
                    }

                    int diffusionNumber = 0;

                    if(table[x][y] != 0) {
                        if(x + 1 < xSize && table[x + 1][y] != -1) {
                            nextTable[x + 1][y] +=  table[x][y] / 5;
                            diffusionNumber++;
                        }

                        if(x - 1 >= 0 && table[x - 1][y] != -1) {
                            nextTable[x - 1][y] += table[x][y] / 5;
                            diffusionNumber++;
                        }

                        if(y + 1 < ySize && table[x][y + 1] != -1) {
                            nextTable[x][y + 1] += table[x][y] / 5;
                            diffusionNumber++;
                        }

                        if(y - 1 >= 0 && table[x][y - 1] != -1) {
                            nextTable[x][y - 1] += table[x][y] / 5;
                            diffusionNumber++;
                        }
                    }


                    nextTable[x][y] += table[x][y] - (table[x][y] / 5) * diffusionNumber;
                }
            }

            table = nextTable;

            for(int x = upper[0] - 1; x > 0; x--) {
                table[x][0] = table[x - 1][0];
            }

            for(int y = 0; y < ySize - 1; y++) {
                table[0][y] = table[0][y + 1];
            }

            for(int x = 0; x < upper[0]; x++) {
                table[x][ySize - 1] = table[x + 1][ySize - 1];
            }

            for (int y = ySize - 1; y > 1; y--) {
                table[upper[0]][y] = table[upper[0]][y - 1];
            }

            table[upper[0]][1] = 0;

            for(int x = lower[0] + 1; x < xSize - 1; x++) {
                table[x][0] = table[x + 1][0];
            }

            for(int y = 0; y < ySize - 1; y++) {
                table[xSize - 1][y] = table[xSize - 1][y + 1];
            }

            for(int x = xSize - 1; x > lower[0]; x--) {
                table[x][ySize - 1] = table[x - 1][ySize - 1];
            }

            for(int y = ySize - 1; y > 1; y--) {
                table[lower[0]][y] = table[lower[0]][y - 1];
            }

            table[lower[0]][1] = 0;
        }

        int sum = 0;
        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                if(table[x][y] != -1) {
                    sum += table[x][y];
                }
            }
        }

        System.out.println(sum);
    }
}
