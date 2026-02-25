import java.io.*;
import java.util.*;

public class P9328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());

        while(testcaseNumber != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xSize = Integer.parseInt(st.nextToken());
            int ySize = Integer.parseInt(st.nextToken());

            char[][] table = new char[xSize + 2][ySize + 2];

            Arrays.fill(table[0], '.');
            Arrays.fill(table[xSize + 1], '.');
            for(int x = 0; x <= xSize + 1; x++) {
                table[x][0] = '.';
                table[x][ySize + 1] = '.';
            }

            for(int x = 1; x <= xSize; x++) {
                String sentence = br.readLine();

                for(int y = 1; y <= ySize; y++) {
                    table[x][y] = sentence.charAt(y - 1);
                }
            }

            HashMap<Character, Boolean> keys = new HashMap<>();
            String keyList = br.readLine();
            for(int i = 0; i < keyList.length(); i++) {
                keys.put(keyList.charAt(i), true);
            }

            Queue<int[]> q = new LinkedList<>();
            boolean[][] isVisited = new boolean[xSize + 2][ySize + 2];
            q.add(new int[]{0, 0});
            isVisited[0][0] = true;
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};

            int count = 0;
            while(!q.isEmpty()) {
                int[] position = q.poll();
                int xPos = position[0];
                int yPos = position[1];

                for(int i = 0; i < 4; i++) {
                    int nextX = xPos + dx[i];
                    int nextY = yPos + dy[i];

                    if(nextX < 0 || nextY < 0 || nextX == xSize + 2 || nextY == ySize + 2 || table[nextX][nextY] == '*') {
                        continue;
                    }

                    if(!isVisited[nextX][nextY]) {
                        if(Character.isUpperCase(table[nextX][nextY])) {
                            if(keys.get(Character.toLowerCase(table[nextX][nextY])) != null) {
                                if(keys.get(Character.toLowerCase(table[nextX][nextY])) == true) {
                                    table[nextX][nextY] = '.';
                                    isVisited[nextX][nextY] = true;
                                    q.add(new int[]{nextX, nextY});
                                }
                            }
                        }
                    }

                    if(!isVisited[nextX][nextY]) {
                        if(Character.isLowerCase(table[nextX][nextY])) {
                            keys.put(table[nextX][nextY], true);
                            table[nextX][nextY] = '.';

                            for(int x = 0; x <= xSize + 1; x++) {
                                Arrays.fill(isVisited[x], false);
                            }

                            q.clear();
                            q.add(new int[]{0, 0});
                        }
                    }

                    if(!isVisited[nextX][nextY]) {
                        if(table[nextX][nextY] == '$') {
                            count++;
                            table[nextX][nextY] = '.';
                            isVisited[nextX][nextY] = true;
                            q.add(new int[]{nextX, nextY});
                        }
                    }

                    if(!isVisited[nextX][nextY]) {
                        if(table[nextX][nextY] == '.') {
                            isVisited[nextX][nextY] = true;
                            q.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }

            System.out.println(count);

            testcaseNumber--;
        }
    }
}
