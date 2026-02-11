import java.io.*;
import java.util.*;

public class P16234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] table = new int[size][size];

        for(int x = 0; x < size; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true) {
            boolean[][] isVisited = new boolean[size][size];
            boolean isUnionExist = false;
            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    if(!isVisited[x][y]) {
                        if(BFS(x, y, isVisited, size, L, R, table) >= 2) {
                            isUnionExist = true;
                        }
                    }
                }
            }

            if(isUnionExist == false) {
                break;
            }

            day++;
        }

        System.out.println(day);
    }

    public static int BFS(int xPos, int yPos, boolean[][] isVisited, int size, int L, int R, int[][] table) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        q.add(new int[]{xPos, yPos});
        union.add(new int[]{xPos, yPos});
        isVisited[xPos][yPos] = true;

        int sum = table[xPos][yPos];

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int xPosition = position[0];
            int yPosition = position[1];

            if(xPosition + 1 < size) {
                int difference = Math.abs(table[xPosition][yPosition] - table[xPosition + 1][yPosition]);
                if(difference >= L && difference <= R) {
                    if(!isVisited[xPosition + 1][yPosition]) {
                        q.add(new int[]{xPosition + 1, yPosition});
                        union.add(new int[]{xPosition + 1, yPosition});

                        sum += table[xPosition + 1][yPosition];
                        isVisited[xPosition + 1][yPosition] = true;
                    }
                }
            }

            if (xPosition - 1 >= 0) {
                int difference = Math.abs(table[xPosition][yPosition] - table[xPosition - 1][yPosition]);
                if(difference >= L && difference <= R) {
                    if(!isVisited[xPosition - 1][yPosition]) {
                        q.add(new int[]{xPosition - 1, yPosition});
                        union.add(new int[]{xPosition - 1, yPosition});

                        sum += table[xPosition - 1][yPosition];
                        isVisited[xPosition - 1][yPosition] = true;
                    }
                }
            }

            if(yPosition + 1 < size) {
                int difference = Math.abs(table[xPosition][yPosition] - table[xPosition][yPosition + 1]);
                if(difference >= L && difference <= R) {
                    if(!isVisited[xPosition][yPosition + 1]) {
                        q.add(new int[]{xPosition, yPosition + 1});
                        union.add(new int[]{xPosition, yPosition + 1});

                        sum += table[xPosition][yPosition + 1];
                        isVisited[xPosition][yPosition + 1] = true;
                    }
                }
            }

            if(yPosition - 1 >= 0) {
                int difference = Math.abs(table[xPosition][yPosition] - table[xPosition][yPosition - 1]);
                if(difference >= L && difference <= R) {
                    if(!isVisited[xPosition][yPosition - 1]) {
                        q.add(new int[]{xPosition, yPosition - 1});
                        union.add(new int[]{xPosition, yPosition - 1});

                        sum += table[xPosition][yPosition - 1];
                        isVisited[xPosition][yPosition - 1] = true;
                    }
                }
            }
        }

        int result = sum / union.size();

        for(int i = 0; i < union.size(); i++) {
            int[] position = union.get(i);
            int xPosition = position[0];
            int yPosition = position[1];

            table[xPosition][yPosition] = result;
        }

        return union.size();
    }
}
