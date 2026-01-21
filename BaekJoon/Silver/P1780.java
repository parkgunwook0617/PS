import java.io.*;
import java.util.*;

public class P1780 {
    public static int minus = 0;
    public static int zero = 0;
    public static int plus = 0;

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

        paper(table, size, 0, 0);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void paper(int[][] table, int size, int xPos, int yPos) {
        boolean isMinus = true;
        boolean isZero = true;
        boolean isPlus = true;

        for(int x = xPos; x < xPos + size; x++) {
            for(int y = yPos; y < yPos + size; y++) {
                if(table[x][y] == -1) {
                    isZero = false;
                    isPlus = false;
                } else if (table[x][y] == 0) {
                    isMinus = false;
                    isPlus = false;
                } else {
                    isMinus = false;
                    isZero = false;
                }
            }
        }

        if(!isMinus && !isZero && !isPlus) {
            paper(table, size / 3, xPos, yPos);
            paper(table, size / 3, xPos, yPos + size / 3);
            paper(table, size / 3, xPos, yPos + 2 * size / 3);
            paper(table, size / 3, xPos + size / 3, yPos);
            paper(table, size / 3, xPos + size / 3, yPos + size / 3);
            paper(table, size / 3, xPos + size / 3, yPos + 2 * size / 3);
            paper(table, size / 3, xPos + 2 * size / 3, yPos);
            paper(table, size / 3, xPos + 2 * size / 3, yPos + size / 3);
            paper(table, size / 3, xPos + 2 * size / 3, yPos + 2 * size / 3);
        } else if (isMinus) {
            minus++;
        } else if (isZero) {
            zero++;
        } else {
            plus++;
        }
    }
}
