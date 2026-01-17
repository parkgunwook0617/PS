import java.io.*;
import java.util.*;

public class P7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = Integer.parseInt(br.readLine());

        while(caseNumber != 0) {
            int size = Integer.parseInt(br.readLine());
            int[][] visited = new int[size][size];
            Queue<int[]> q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            q.add(new int[]{startX, startY});
            visited[startX][startY] = 1;

            while(!q.isEmpty()) {
                int[] position = q.poll();
                int xPosition = position[0];
                int yPosition = position[1];

                if(xPosition - 1 >= 0 && yPosition - 2  >= 0) {
                    if(visited[xPosition - 1][yPosition - 2] == 0) {
                        visited[xPosition - 1][yPosition - 2] = visited[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition - 1, yPosition - 2});
                    }
                }

                if(xPosition - 2 >= 0 && yPosition - 1 >= 0) {
                    if(visited[xPosition - 2][yPosition - 1] == 0) {
                        visited[xPosition - 2][yPosition - 1] = visited[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition - 2, yPosition - 1});
                    }
                }

                if(xPosition - 1 >= 0 && yPosition + 2 < size) {
                    if(visited[xPosition - 1][yPosition + 2] == 0) {
                        visited[xPosition - 1][yPosition + 2] = visited[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition - 1, yPosition + 2});
                    }
                }

                if(xPosition - 2 >= 0 && yPosition + 1 < size) {
                    if(visited[xPosition - 2][yPosition + 1] == 0) {
                        visited[xPosition - 2][yPosition + 1] = visited[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition - 2, yPosition + 1});
                    }
                }

                if(xPosition + 2 < size && yPosition + 1 < size) {
                    if(visited[xPosition + 2][yPosition + 1] == 0) {
                        visited[xPosition + 2][yPosition + 1] = visited[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition + 2, yPosition + 1});
                    }
                }

                if(xPosition + 1 < size && yPosition + 2 < size) {
                    if(visited[xPosition + 1][yPosition + 2] == 0) {
                        visited[xPosition + 1][yPosition + 2] = visited[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition + 1, yPosition + 2});
                    }
                }

                if(xPosition + 2 < size && yPosition - 1 >= 0) {
                    if(visited[xPosition + 2][yPosition - 1] == 0) {
                        visited[xPosition + 2][yPosition - 1] = visited[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition + 2, yPosition - 1});
                    }
                }

                if(xPosition + 1 < size && yPosition - 2 >= 0) {
                    if(visited[xPosition + 1][yPosition - 2] == 0) {
                        visited[xPosition + 1][yPosition - 2] = visited[xPosition][yPosition] + 1;
                        q.add(new int[]{xPosition + 1, yPosition - 2});
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int targetXPos = Integer.parseInt(st.nextToken());
            int targetYPos = Integer.parseInt(st.nextToken());

            System.out.println(visited[targetXPos][targetYPos] - 1);

            caseNumber--;
        }
    }
}
