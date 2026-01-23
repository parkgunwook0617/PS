import java.io.*;
import java.util.*;

public class P2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize1 = Integer.parseInt(st.nextToken());
        int ySize1 = Integer.parseInt(st.nextToken());
        int[][] table1 = new int[xSize1][ySize1];
        for(int x = 0; x < xSize1; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize1; y++) {
                table1[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int xSize2 = Integer.parseInt(st.nextToken());
        int ySize2 = Integer.parseInt(st.nextToken());
        int[][] table2 = new int[xSize2][ySize2];
        for(int x = 0; x < xSize2; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize2; y++) {
                table2[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < xSize1; i++) {
            for(int k = 0; k < ySize2; k++) {
                int sum = 0;
                for(int j = 0; j < ySize1; j++) {
                    sum += table1[i][j] * table2[j][k];
                }
                System.out.print(sum + " ");
            }

            System.out.println();
        }
    }
}
