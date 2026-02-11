import java.io.*;
import java.util.*;

public class P14499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        int xPos = Integer.parseInt(st.nextToken());
        int yPos = Integer.parseInt(st.nextToken());
        int orderNumber = Integer.parseInt(st.nextToken());

        int[][] table = new int[xSize][ySize];
        for(int x = 0; x < xSize; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[7]; // 1:위, 2:북, 3:동, 4:서, 5:남, 6:바닥

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < orderNumber; i++) {
            int nextDirection = Integer.parseInt(st.nextToken());

            if(nextDirection == 1) {
                //동
                if(yPos + 1 >= ySize) {
                    continue;
                }

                yPos++;

                int temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;

                if(table[xPos][yPos] == 0) {
                    table[xPos][yPos] = dice[6];
                } else {
                    dice[6] = table[xPos][yPos];
                    table[xPos][yPos] = 0;
                }
            } else if (nextDirection == 2) {
                //서
                if(yPos - 1 < 0) {
                    continue;
                }

                yPos--;

                int temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;

                if(table[xPos][yPos] == 0) {
                    table[xPos][yPos] = dice[6];
                } else {
                    dice[6] = table[xPos][yPos];
                    table[xPos][yPos] = 0;
                }
            } else if (nextDirection == 3) {
                //북
                if(xPos - 1 < 0) {
                    continue;
                }

                xPos--;

                int temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;

                if(table[xPos][yPos] == 0) {
                    table[xPos][yPos] = dice[6];
                } else {
                    dice[6] = table[xPos][yPos];
                    table[xPos][yPos] = 0;
                }
            } else if (nextDirection == 4) {
                //남
                if(xPos + 1 >= xSize) {
                    continue;
                }

                xPos++;

                int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;

                if(table[xPos][yPos] == 0) {
                    table[xPos][yPos] = dice[6];
                } else {
                    dice[6] = table[xPos][yPos];
                    table[xPos][yPos] = 0;
                }
            }

            System.out.println(dice[1]);
        }
    }
}
