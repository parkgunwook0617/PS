import java.io.*;
import java.util.*;

public class P2636 {
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
        int previousSize = 0;

        while(true) {
            boolean[][] isVisited = new boolean[xSize][ySize];
            Queue<int[]> q = new LinkedList<>();
            Queue<int[]> removeList = new LinkedList<>();
            q.add(new int[]{0, 0});
            isVisited[0][0] = true;
            while(!q.isEmpty()) {
                int[] position = q.poll();
                int xPos = position[0];
                int yPos = position[1];

                if(xPos + 1 < xSize) {
                    if(table[xPos + 1][yPos] == 0) {
                        if(!isVisited[xPos + 1][yPos]) {
                            isVisited[xPos + 1][yPos] = true;
                            q.add(new int[]{xPos + 1, yPos});
                        }
                    }

                    if(table[xPos + 1][yPos] == 1) {
                        if(!isVisited[xPos + 1][yPos]) {
                            isVisited[xPos + 1][yPos] = true;
                            removeList.add(new int[]{xPos + 1, yPos});
                        }
                    }
                }

                if(xPos - 1 >= 0) {
                    if(table[xPos - 1][yPos] == 0) {
                        if(!isVisited[xPos - 1][yPos]) {
                            isVisited[xPos - 1][yPos] = true;
                            q.add(new int[]{xPos - 1, yPos});
                        }
                    }

                    if(table[xPos - 1][yPos] == 1) {
                        if(!isVisited[xPos - 1][yPos]) {
                            isVisited[xPos - 1][yPos] = true;
                            removeList.add(new int[]{xPos - 1, yPos});
                        }
                    }
                }

                if(yPos + 1 < ySize) {
                    if(table[xPos][yPos + 1] == 0) {
                        if(!isVisited[xPos][yPos + 1]) {
                            isVisited[xPos][yPos + 1] = true;
                            q.add(new int[]{xPos, yPos + 1});
                        }
                    }

                    if(table[xPos][yPos + 1] == 1) {
                        if(!isVisited[xPos][yPos + 1]) {
                            isVisited[xPos][yPos + 1] = true;
                            removeList.add(new int[]{xPos, yPos + 1});
                        }
                    }
                }

                if(yPos - 1 >= 0) {
                    if(table[xPos][yPos - 1] == 0) {
                        if(!isVisited[xPos][yPos - 1]) {
                            isVisited[xPos][yPos - 1] = true;
                            q.add(new int[]{xPos, yPos - 1});
                        }
                    }

                    if(table[xPos][yPos - 1] == 1) {
                        if(!isVisited[xPos][yPos - 1]) {
                            isVisited[xPos][yPos - 1] = true;
                            removeList.add(new int[]{xPos, yPos - 1});
                        }
                    }
                }
            }

            if(removeList.isEmpty()) {
                break;
            }

            previousSize = removeList.size();

            while(!removeList.isEmpty()) {
                int[] removePosition = removeList.poll();
                int removeX = removePosition[0];
                int removeY = removePosition[1];

                table[removeX][removeY] = 0;
            }

            time++;
        }

        System.out.println(time);
        System.out.println(previousSize);
    }
}
