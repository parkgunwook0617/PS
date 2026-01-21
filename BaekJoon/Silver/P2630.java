import java.io.*;
import java.util.*;

public class P2630 {
    public static int blueCount = 0;
    public static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        char[][] table = new char[size][size];

        for(int x = 0; x < size; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                table[x][y] = st.nextToken().charAt(0);
            }
        }

        paper(table, size, 0, 0);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    public static void paper(char[][] table, int size, int xPos, int yPos) {
        boolean allSame = true;
        char initialValue = table[xPos][yPos];
        for(int x = xPos; x < xPos + size; x ++) {
            for(int y = yPos; y < yPos + size; y++) {
                if(table[x][y] != initialValue) {
                    allSame = false;
                    break;
                }
            }

            if(!allSame) {
                break;
            }
        }

        if(!allSame) {
            paper(table, size / 2, xPos, yPos);
            paper(table, size / 2, xPos, yPos + size / 2);
            paper(table, size / 2, xPos + size / 2, yPos);
            paper(table, size / 2, xPos + size / 2, yPos + size / 2);
        } else {
            if(initialValue == '1') {
                blueCount++;
            } else {
                whiteCount++;
            }
        }
    }
}
