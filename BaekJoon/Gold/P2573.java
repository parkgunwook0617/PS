import java.io.*;
import java.util.*;

public class P2573 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        int[][] table = new int[xSize][ySize];

        for(int x = 0; x < xSize; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int[][] meltTable = new int[xSize][ySize];

        while(true) {
            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    int meltCount = 0;

                    if(x + 1 < xSize) {
                        if(table[x + 1][y] == 0) {
                            meltCount++;
                        }
                    }

                    if(x - 1 >= 0) {
                        if(table[x - 1][y] == 0) {
                            meltCount++;
                        }
                    }

                    if(y + 1 < ySize) {
                        if(table[x][y + 1] == 0) {
                            meltCount++;
                        }
                    }

                    if(y - 1 >= 0) {
                        if(table[x][y - 1] == 0) {
                            meltCount++;
                        }
                    }

                    meltTable[x][y] = meltCount;
                }
            }

            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(table[x][y] - meltTable[x][y] >= 0) {
                        table[x][y] -= meltTable[x][y];
                    } else {
                        table[x][y] = 0;
                    }
                }
            }

            int[][] checkTable = new int[xSize][ySize];
            for(int x = 0; x < xSize; x++) {
                checkTable[x] = table[x].clone();
            }

            boolean[][] isVisited = new boolean[xSize][ySize];
            int part = 0;
            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(checkTable[x][y] != 0) {
                        BFS(checkTable, x, y, xSize, ySize, isVisited);
                        part++;
                    }
                }
            }

            time++;

            if(part >= 2) {
                break;
            } else if (part == 0) {
                time = 0;
                break;
            }
        }

        System.out.println(time);
    }

    public static void BFS(int[][] table, int xPos, int yPos, int xSize, int ySize, boolean[][] isVisited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{xPos, yPos});
        isVisited[xPos][yPos] = true;

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int x = position[0];
            int y = position[1];

            if(x + 1 < xSize) {
                if(table[x + 1][y] != 0 && !isVisited[x + 1][y]) {
                    isVisited[x + 1][y] = true;
                    q.add(new int[]{x + 1, y});
                }
            }

            if(x - 1 >= 0) {
                if(table[x - 1][y] != 0 && !isVisited[x - 1][y]) {
                    isVisited[x - 1][y] = true;
                    q.add(new int[]{x - 1, y});
                }
            }

            if(y + 1 < ySize) {
                if(table[x][y + 1] != 0 && !isVisited[x][y + 1]) {
                    isVisited[x][y + 1] = true;
                    q.add(new int[]{x, y + 1});
                }
            }

            if(y - 1 >= 0) {
                if(table[x][y - 1] != 0 && !isVisited[x][y - 1]) {
                    isVisited[x][y - 1] = true;
                    q.add(new int[]{x, y - 1});
                }
            }

            table[x][y] = 0;
        }
    }
}
