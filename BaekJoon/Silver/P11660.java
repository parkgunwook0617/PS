import java.io.*;
import java.util.*;

public class P11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int testcaseNumber = Integer.parseInt(st.nextToken());

        int[][] table = new int[size][size];
        int[][] sumTable = new int[size][size];
        for(int x = 0; x < size; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x = 0; x < size; x++) {
            sumTable[x][0] = table[x][0];
        }

        for(int x = 0; x < size; x++) {
            for(int y = 1; y < size; y++) {
                sumTable[x][y] = sumTable[x][y - 1] + table[x][y];
            }
        }

        for(int i = 0; i < testcaseNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int x = startX - 1; x < endX; x++) {
                if(startY - 2 < 0) {
                    sum += sumTable[x][endY - 1];
                } else {
                    sum += sumTable[x][endY - 1] - sumTable[x][startY - 2];
                }
            }

            System.out.println(sum);
        }
    }
}
