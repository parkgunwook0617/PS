import java.io.*;
import java.util.*;

public class P1987 {
    public static int maxStep = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        char[][] table = new char[xSize][ySize];

        for(int x = 0; x < xSize; x++) {
            String sentence = br.readLine();

            for(int y = 0; y < ySize; y++) {
                table[x][y] = sentence.charAt(y);
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put(table[0][0], 1);

        DFS(table, xSize, ySize, 0, 0, map, 1);

        System.out.println(maxStep);
    }

    public static void DFS(char[][] table, int xSize, int ySize, int x, int y, HashMap<Character, Integer> map, int count) {
        maxStep = Math.max(maxStep, count);

        if(x + 1 < xSize) {
            if(map.get(table[x + 1][y]) == null || map.get(table[x + 1][y]) == 0) {
                map.put(table[x + 1][y], map.getOrDefault(table[x + 1][y], 0) + 1);
                DFS(table, xSize, ySize, x + 1, y, map, count + 1);
                map.put(table[x + 1][y], map.get(table[x + 1][y]) - 1);
            }
        }

        if(x - 1 >= 0) {
            if(map.get(table[x - 1][y]) == null || map.get(table[x - 1][y]) == 0) {
                map.put(table[x - 1][y], map.getOrDefault(table[x - 1][y], 0) + 1);
                DFS(table, xSize, ySize, x - 1, y, map, count + 1);
                map.put(table[x - 1][y], map.get(table[x - 1][y]) - 1);
            }
        }

        if(y + 1 < ySize) {
            if(map.get(table[x][y + 1]) == null || map.get(table[x][y + 1]) == 0) {
                map.put(table[x][y + 1], map.getOrDefault(table[x][y + 1], 0) + 1);
                DFS(table, xSize, ySize, x, y + 1, map, count + 1);
                map.put(table[x][y + 1], map.get(table[x][y + 1]) - 1);
            }
        }

        if(y - 1 >= 0) {
            if(map.get(table[x][y - 1]) == null || map.get(table[x][y - 1]) == 0) {
                map.put(table[x][y - 1], map.getOrDefault(table[x][y - 1], 0) + 1);
                DFS(table, xSize, ySize, x, y - 1, map, count + 1);
                map.put(table[x][y - 1], map.get(table[x][y - 1]) - 1);
            }
        }
    }
}
