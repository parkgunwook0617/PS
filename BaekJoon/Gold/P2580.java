import java.io.*;
import java.util.*;

public class P2580 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] table = new int[9][9];
        boolean[][] isUsed = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isUsedChecker(table, isUsed, 0, 0);
        isUsedChecker(table, isUsed, 1, 0);
        isUsedChecker(table, isUsed, 2, 0);
        isUsedChecker(table, isUsed, 0, 1);
        isUsedChecker(table, isUsed, 1, 1);
        isUsedChecker(table, isUsed, 2, 1);
        isUsedChecker(table, isUsed, 0, 2);
        isUsedChecker(table, isUsed, 1, 2);
        isUsedChecker(table, isUsed, 2, 2);

        simulation(table, isUsed, 0, 0);
    }

    public static void simulation(int[][] table, boolean[][] isUsed, int xPosition, int yPosition) {
        if(xPosition == 9) {
            StringBuilder sb = new StringBuilder();
            count++;
            for(int x = 0; x < 9; x++) {
                for(int y = 0; y < 9; y++) {
                    sb.append(table[x][y] + " ");
                }
                sb.append("\n");
                }

            System.out.println(sb);
            System.exit(0);
        }

        if(table[xPosition][yPosition] == 0) {
            for(int i = 1; i <= 9; i++) {
                boolean isTrue = true;
                if(isUsed[xPosition / 3 + 3 * (yPosition / 3)][i - 1]) {
                    isTrue = false;
                    continue;
                }

                for(int x = 0; x < 9; x++) {
                    if(table[x][yPosition] == i) {
                        isTrue = false;
                        break;
                    }
                }

                for(int y = 0; y < 9; y++) {
                    if(table[xPosition][y] == i) {
                        isTrue = false;
                        break;
                    }
                }

                if(isTrue) {
                    table[xPosition][yPosition] = i;
                    isUsed[xPosition / 3 + 3 * (yPosition / 3)][i - 1] = true;
                    if(yPosition < 8) {
                        simulation(table, isUsed, xPosition, yPosition + 1);
                    } else {
                        simulation(table, isUsed, xPosition + 1, 0);
                    }
                    table[xPosition][yPosition] = 0;
                    isUsed[xPosition / 3 + 3 * (yPosition / 3)][i - 1] = false;
                }
            }
        } else {
            if(yPosition < 8) {
                simulation(table, isUsed, xPosition, yPosition + 1);
            } else {
                simulation(table, isUsed, xPosition + 1, 0);
            }
        }
    }

    public static void isUsedChecker(int[][] table, boolean[][] isUsed, int x, int y) {
        for(int i = 3 * x; i < 3 * x + 3; i++) {
            for(int k = 3 * y; k < 3 * y + 3 ; k++) {
                if(table[i][k] - 1 == -1) {
                } else {
                    isUsed[x + (3 * y)][table[i][k] - 1] = true;
                }
            }
        }
    }
}
