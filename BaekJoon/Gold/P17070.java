import java.io.*;
import java.util.*;

public class P17070 {
    public static int way = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] table = new int[size][size];

        for(int x = 0; x < size; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(table, 0, 0, 0, 1, size);

        System.out.println(way);
    }

    public static void simulation(int[][] table, int xPos1, int yPos1, int xPos2, int yPos2, int size) {
        if(xPos2 == size - 1 && yPos2 == size - 1) {
            way++;
            return;
        }

        if(xPos2 == xPos1 + 1 && yPos2 == yPos1 + 1) {
            if(yPos2 + 1 < size) {
                if(table[xPos2][yPos2 + 1] != 1) {
                    simulation(table, xPos1 + 1, yPos1 + 1, xPos2, yPos2 + 1, size);
                }
            }

            if(xPos2 + 1 < size && yPos2 + 1 < size) {
                if(table[xPos2][yPos2 + 1] != 1 && table[xPos2 + 1][yPos2 + 1] != 1 && table[xPos2 + 1][yPos2] != 1) {
                    simulation(table, xPos1 + 1, yPos1 + 1, xPos2 + 1, yPos2 + 1, size);
                }
            }

            if(xPos2 + 1 < size) {
                if(table[xPos2 + 1][yPos2] != 1) {
                    simulation(table, xPos1 + 1, yPos1 + 1, xPos2 + 1, yPos2, size);
                }
            }
        } else if (xPos1 == xPos2 && yPos2 == yPos1 + 1) {
            if(yPos2 + 1 < size) {
                if(table[xPos2][yPos2 + 1] != 1) {
                    simulation(table, xPos1, yPos1 + 1, xPos2, yPos2 + 1, size);
                }
            }

            if(xPos2 + 1 < size && yPos2 + 1 < size) {
                if(table[xPos2][yPos2 + 1] != 1 && table[xPos2 + 1][yPos2 + 1] != 1 && table[xPos2 + 1][yPos2] != 1) {
                    simulation(table, xPos1, yPos1 + 1, xPos2 + 1, yPos2 + 1, size);
                }
            }
        } else if (yPos1 == yPos2 && xPos2 == xPos1 + 1) {
            if(xPos2 + 1 < size) {
                if(table[xPos2 + 1][yPos2] != 1) {
                    simulation(table, xPos1 + 1, yPos1, xPos2 + 1, yPos2, size);
                }
            }

            if(xPos2 + 1 < size && yPos2 + 1 < size) {
                if(table[xPos2 + 1][yPos2] != 1 && table[xPos2 + 1][yPos2 + 1] != 1 && table[xPos2][yPos2 + 1] != 1) {
                    simulation(table, xPos1 + 1, yPos1, xPos2 + 1, yPos2 + 1, size);
                }
            }
        }
    }
}
