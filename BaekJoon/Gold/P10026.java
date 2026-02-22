import java.io.*;
import java.util.*;

public class P10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[][] table = new char[size][size];

        for(int x = 0; x < size; x++) {
            String sentence = br.readLine();

            for(int y = 0; y < size; y++) {
                table[x][y] = sentence.charAt(y);
            }
        }
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        boolean[][] isVisited = new boolean[size][size];
        int area = 0;
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(!isVisited[x][y]) {
                    isVisited[x][y] = true;
                    char target = table[x][y];

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{x, y});

                    while(!q.isEmpty()) {
                        int[] position = q.poll();
                        int xPos = position[0];
                        int yPos = position[1];

                        for(int i = 0; i < 4; i++) {
                            int nextX = xPos + dx[i];
                            int nextY = yPos + dy[i];

                            if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size) {
                                if (!isVisited[nextX][nextY] && table[nextX][nextY] == target) {
                                    isVisited[nextX][nextY] = true;
                                    q.add(new int[]{nextX, nextY});
                                }
                            }
                        }
                    }

                    area++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(area).append(" ");

        area = 0;
        isVisited = new boolean[size][size];

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(table[x][y] == 'G') {
                    table[x][y] = 'R';
                }
            }
        }

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(!isVisited[x][y]) {
                    isVisited[x][y] = true;
                    char target = table[x][y];

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{x, y});

                    while(!q.isEmpty()) {
                        int[] position = q.poll();
                        int xPos = position[0];
                        int yPos = position[1];

                        for(int i = 0; i < 4; i++) {
                            int nextX = xPos + dx[i];
                            int nextY = yPos + dy[i];

                            if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size) {
                                if (!isVisited[nextX][nextY] && table[nextX][nextY] == target) {
                                    isVisited[nextX][nextY] = true;
                                    q.add(new int[]{nextX, nextY});
                                }
                            }
                        }
                    }

                    area++;
                }
            }
        }

        sb.append(area);

        System.out.println(sb);
    }
}
