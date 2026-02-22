import java.io.*;
import java.util.*;

public class P13460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        char[][] table = new char[xSize][ySize];
        int startRX = 0;
        int startRY = 0;
        int startBX = 0;
        int startBY = 0;

        for(int x = 0; x < xSize; x++) {
            String sentence = br.readLine();

            for(int y = 0; y < ySize; y++) {
                table[x][y] = sentence.charAt(y);

                if(table[x][y] == 'R') {
                    startRX = x;
                    startRY = y;
                } else if (table[x][y] == 'B') {
                    startBX = x;
                    startBY = y;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[xSize][ySize][xSize][ySize];
        q.add(new int[]{startRX, startRY, startBX, startBY, 1});

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        while(!q.isEmpty()) {
            int[] data = q.poll();
            int currentRX = data[0];
            int currentRY = data[1];
            int currentBX = data[2];
            int currentBY = data[3];
            int step = data[4];

            if(step > 10) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int[] nextRed = move(table, currentRX, currentRY, dx[i], dy[i]);
                int[] nextBlue = move(table, currentBX, currentBY, dx[i], dy[i]);

                if(table[nextBlue[0]][nextBlue[1]] == 'O') {
                    continue;
                }
                if(table[nextRed[0]][nextRed[1]] == 'O') {
                    System.out.println(step);
                    return;
                }

                if(nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                    if(nextRed[2] > nextBlue[2]) {
                        nextRed[0] -= dx[i];
                        nextRed[1] -= dy[i];
                    } else {
                        nextBlue[0] -= dx[i];
                        nextBlue[1] -= dy[i];
                    }
                }

                if(!visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
                    visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
                    q.add(new int[]{nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], step + 1});
                }
            }
        }

        System.out.println(-1);
    }

    public static int[] move(char[][] table, int x, int y, int dx, int dy) {
        int count = 0;

        while(table[x + dx][y + dy] != '#' && table[x][y] != 'O') {
            x += dx;
            y += dy;
            count += 1;
        }

        return (new int[]{x, y, count});
    }
}
