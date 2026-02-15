import java.io.*;
import java.util.*;

public class P14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        int[][] table = new int[xSize][ySize];

        st = new StringTokenizer(br.readLine());

        for(int y = 0; y < ySize; y++) {
            int height = Integer.parseInt(st.nextToken());

            for(int x = 0; x < height; x++) {
                table[x][y] = 1;
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int x = 0; x < xSize; x++) {
            list.add(new ArrayList<>());
        }

        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                if(table[x][y] == 1) {
                    list.get(x).add(y);
                }
            }
        }

        int sum = 0;
        for(int x = 0; x < xSize; x++) {
            if(list.get(x).size() >= 2) {
                for(int y = 0; y < list.get(x).size() - 1; y++) {
                    sum += Math.abs(list.get(x).get(y + 1) - list.get(x).get(y) - 1);
                }
            }
        }

        System.out.println(sum);
    }
}
