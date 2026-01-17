import java.io.*;
import java.util.*;

public class P2667 {
    public static boolean[][] visited;
    public static char[][] map;
    public static int count = 0;
    public static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        map = new char[size][size];

        visited = new boolean[size][size];

        for(int x = 0; x < size; x++) {
            String line = br.readLine();

            for(int y = 0; y < size; y++) {
                map[x][y] = line.charAt(y);
            }
        }

        List<Integer> houseNumber = new ArrayList<>();
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(map[x][y] == '1' && !visited[x][y]) {
                    DFS(x, y);
                    houseNumber.add(count);
                    count = 0;
                }
            }
        }

        houseNumber.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(houseNumber.size()).append("\n");
        for(int number : houseNumber) {
            sb.append(number).append("\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        count++;

        if(x + 1 < size) {
            if(map[x + 1][y] == '1' && !visited[x + 1][y]) {
                DFS(x + 1, y);
            }
        }

        if(x - 1 >= 0) {
            if(map[x - 1][y] == '1' && !visited[x - 1][y]) {
                DFS(x - 1, y);
            }

        }

        if(y + 1 < size) {
            if(map[x][y + 1] == '1' && !visited[x][y + 1]) {
                DFS(x, y + 1);
            }
        }

        if(y - 1 >= 0) {
            if(map[x][y - 1] == '1' && !visited[x][y - 1]) {
                DFS(x, y - 1);
            }
        }
    }
}
