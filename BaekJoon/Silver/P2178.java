import java.io.*;
import java.util.*;

public class P2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        int[][] table = new int[xSize][ySize];
        int[][] visited = new int[xSize][ySize];
        int[][] length = new int[xSize][ySize];

        for(int x = 0; x < xSize; x++) {
            String sentence = br.readLine();

            for(int y = 0; y < ySize; y++) {
                if(sentence.charAt(y) == '1') {
                    table[x][y] = 1;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            int[] position = q.poll();
            int xPosition = position[0];
            int yPosition = position[1];

            if(xPosition + 1 < xSize) {
                if(visited[xPosition + 1][yPosition] != 1) {
                    if(table[xPosition + 1][yPosition] == 1) {
                        length[xPosition + 1][yPosition] = length[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition + 1, yPosition});
                        visited[xPosition + 1][yPosition] = 1;
                    }
                }
            }

            if(xPosition - 1 >= 0) {
                if(visited[xPosition - 1][yPosition] != 1) {
                    if(table[xPosition - 1][yPosition] == 1) {
                        length[xPosition - 1][yPosition] = length[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition - 1, yPosition});
                        visited[xPosition - 1][yPosition] = 1;
                    }
                }
            }

            if(yPosition + 1 < ySize) {
                if(visited[xPosition][yPosition + 1] != 1) {
                    if(table[xPosition][yPosition + 1] == 1) {
                        length[xPosition][yPosition + 1] = length[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition, yPosition + 1});
                        visited[xPosition][yPosition + 1] = 1;
                    }
                }
            }

            if(yPosition - 1 >= 0) {
                if(visited[xPosition][yPosition - 1] != 1) {
                    if(table[xPosition][yPosition - 1] == 1) {
                        length[xPosition][yPosition - 1] = length[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition, yPosition - 1});
                        visited[xPosition][yPosition - 1] = 1;
                    }
                }
            }
        }

        System.out.println(length[xSize - 1][ySize - 1] + 1);
    }
}
