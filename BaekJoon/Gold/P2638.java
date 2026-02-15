import java.io.*;
import java.util.*;

public class P2638 {
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
        while(true) {
            boolean[][] isVisited = new boolean[xSize][ySize];
            Queue<int[]> q = new LinkedList<>();
            int[][] visitedNumber = new int[xSize][ySize];
            q.add(new int[]{0, 0});
            isVisited[0][0] = true;

            while(!q.isEmpty()) {
                int[] position = q.poll();
                int xPos = position[0];
                int yPos = position[1];

                if(xPos + 1 < xSize) {
                    if(!isVisited[xPos + 1][yPos]) {
                        if(table[xPos + 1][yPos] == 0) {
                            isVisited[xPos + 1][yPos] = true;
                            q.add(new int[]{xPos + 1, yPos});
                        }
                    }

                    if(!isVisited[xPos + 1][yPos]) {
                        if(table[xPos + 1][yPos] == 1) {
                            visitedNumber[xPos + 1][yPos] += 1;
                        }
                    }
                }

                if(xPos - 1 >= 0) {
                    if(!isVisited[xPos - 1][yPos]) {
                        if(table[xPos - 1][yPos] == 0) {
                            isVisited[xPos - 1][yPos] = true;
                            q.add(new int[]{xPos - 1, yPos});
                        }
                    }

                    if(!isVisited[xPos - 1][yPos]) {
                        if(table[xPos - 1][yPos] == 1) {
                            visitedNumber[xPos - 1][yPos] += 1;
                        }
                    }
                }

                if(yPos + 1 < ySize) {
                    if(!isVisited[xPos][yPos + 1]) {
                        if(table[xPos][yPos + 1] == 0) {
                            isVisited[xPos][yPos + 1] = true;
                            q.add(new int[]{xPos, yPos + 1});
                        }
                    }

                    if(!isVisited[xPos][yPos + 1]) {
                        if(table[xPos][yPos + 1] == 1) {
                            visitedNumber[xPos][yPos + 1] += 1;
                        }
                    }
                }

                if(yPos - 1 >= 0) {
                    if(!isVisited[xPos][yPos - 1]) {
                        if(table[xPos][yPos - 1] == 0) {
                            isVisited[xPos][yPos - 1] = true;
                            q.add(new int[]{xPos, yPos - 1});
                        }
                    }

                    if(!isVisited[xPos][yPos - 1]) {
                        if(table[xPos][yPos - 1] == 1) {
                            visitedNumber[xPos][yPos - 1] += 1;
                        }
                    }
                }
            }

            int number = 0;
            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(visitedNumber[x][y] >= 2) {
                        table[x][y] = 0;
                        number++;
                    }
                }
            }

            if(number == 0) {
                break;
            } else {
                time++;
            }
        }

        System.out.println(time);
    }
}
