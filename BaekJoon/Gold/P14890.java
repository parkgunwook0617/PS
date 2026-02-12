import java.io.*;
import java.util.*;

public class P14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] table = new int[size][size];
        for(int x = 0; x < size; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int validNumber = 0;
        for(int x = 0; x < size; x++) {
            if(canGo(table[x], size, L)) {
                validNumber++;
            }
        }

        for(int y = 0; y < size; y++) {
            int[] column = new int[size];

            for(int x = 0; x < size; x++) {
                column[x] = table[x][y];
            }

            if(canGo(column, size, L)) {
                validNumber++;
            }
        }

        System.out.println(validNumber);
    }

    public static boolean canGo(int[] path, int size, int L) {
        boolean[] isInstalled = new boolean[size];

        for (int i = 0; i < size - 1; i++) {
            if (path[i] == path[i + 1]) continue;

            if (Math.abs(path[i] - path[i + 1]) > 1) return false;

            if (path[i] > path[i + 1]) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= size || path[i + 1] != path[i + j] || isInstalled[i + j]) return false;
                    isInstalled[i + j] = true;
                }
            } else {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || path[i] != path[i - j] || isInstalled[i - j]) return false;
                    isInstalled[i - j] = true;
                }
            }
        }

        return true;
    }
}
