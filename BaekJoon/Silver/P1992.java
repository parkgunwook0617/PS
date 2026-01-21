import java.io.*;
import java.util.*;

public class P1992 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        char[][] table = new char[size][size];

        for(int x = 0; x < size; x++) {
            String sentence = br.readLine();

            for(int y = 0; y < size; y++) {
                table[x][y] = sentence.charAt(y);
            }
        }

        quadTree(table, size, 0, 0);


        System.out.println(sb);
    }

    public static void quadTree(char[][] table, int size, int xPos, int yPos) {
        boolean isOne = true;
        boolean isZero = true;

        for(int x = xPos; x < xPos + size; x++) {
            for(int y = yPos; y < yPos + size; y++) {
                if(table[x][y] == '1') {
                    isZero = false;
                }

                if (table[x][y] == '0') {
                    isOne = false;
                }
            }
        }

        if(!isZero && !isOne) {
            sb.append('(');
            quadTree(table, size / 2, xPos, yPos);
            quadTree(table, size / 2, xPos, yPos + size / 2);
            quadTree(table, size / 2, xPos + size / 2, yPos);
            quadTree(table, size / 2, xPos + size / 2, yPos + size / 2);
            sb.append(')');
        } else if (isZero) {
            sb.append(0);
        } else {
            sb.append(1);
        }
    }
}