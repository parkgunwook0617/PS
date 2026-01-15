import java.io.*;
import java.util.*;

public class P2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[][] table = new char[size][size];

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                table[x][y] = '*';
            }
        }

        simulation(table, size, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                sb.append(table[x][y]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void simulation(char[][] table, int size, int startX, int startY) {
        if(size == 1) {
            return;
        }

        for(int x = size / 3 + startX; x < 2 * size / 3 + startX; x++) {
            for(int y = size / 3 + startY; y < 2 * size / 3 + startY; y++) {
                table[x][y] = ' ';
            }
        }

        simulation(table, size / 3, startX, startY);
        simulation(table, size / 3, startX + size / 3, startY);
        simulation(table, size / 3, startX + 2 * (size / 3), startY);
        simulation(table, size / 3, startX, startY + size / 3);
        simulation(table, size / 3, startX, startY + 2 * (size / 3));
        simulation(table, size / 3, startX + size / 3, startY + size / 3);
        simulation(table, size / 3, startX + 2 * (size / 3), startY + size / 3);
        simulation(table, size / 3, startX + size / 3, startY + 2 * (size / 3));
        simulation(table, size / 3, startX + 2 * (size / 3), startY + 2 * (size / 3));
    }
}
