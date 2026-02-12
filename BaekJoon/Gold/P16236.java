import java.io.*;
import java.util.*;

public class P16236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] table = new int[size][size];
        int startX = 0;
        int startY = 0;
        for(int x = 0; x < size; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
                if(table[x][y] == 9) {
                    startX = x;
                    startY = y;
                    table[x][y] = 0;
                }
            }
        }


        int currentSize = 2;
        int currentEat = 0;
        int time = 0;

        while(true) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{startX, startY});

            int[][] isVisited = new int[size][size];
            for(int x = 0; x < size; x++) {
                Arrays.fill(isVisited[x], -1);
            }

            isVisited[startX][startY] = 0;
            List<int[]> eatCandidate = new ArrayList<>();

            while(!q.isEmpty()) {
                int[] position = q.poll();
                int xPos = position[0];
                int yPos = position[1];

                if(xPos + 1 < size) {
                    if(isVisited[xPos + 1][yPos] == -1) {
                        if(table[xPos + 1][yPos] == 0) {
                            q.add(new int[]{xPos + 1, yPos});
                            isVisited[xPos + 1][yPos] = isVisited[xPos][yPos] + 1;
                        } else if (table[xPos + 1][yPos] <= currentSize) {
                            q.add(new int[]{xPos + 1, yPos});
                            isVisited[xPos + 1][yPos] = isVisited[xPos][yPos] + 1;

                            if(table[xPos + 1][yPos] != 0 && table[xPos + 1][yPos] < currentSize) {
                                eatCandidate.add(new int[]{xPos + 1, yPos});
                            }
                        }
                    }
                }

                if(xPos - 1 >= 0) {
                    if(isVisited[xPos - 1][yPos] == -1) {
                        if(table[xPos - 1][yPos] == 0) {
                            q.add(new int[]{xPos - 1, yPos});
                            isVisited[xPos - 1][yPos] = isVisited[xPos][yPos] + 1;
                        } else if (table[xPos - 1][yPos] <= currentSize) {
                            q.add(new int[]{xPos - 1, yPos});
                            isVisited[xPos - 1][yPos] = isVisited[xPos][yPos] + 1;

                            if(table[xPos - 1][yPos] != 0 && table[xPos - 1][yPos] < currentSize) {
                                eatCandidate.add(new int[]{xPos - 1, yPos});
                            }
                        }
                    }
                }

                if(yPos + 1 < size) {
                    if(isVisited[xPos][yPos + 1] == -1) {
                        if(table[xPos][yPos + 1] == 0) {
                            q.add(new int[]{xPos, yPos + 1});
                            isVisited[xPos][yPos + 1] = isVisited[xPos][yPos] + 1;
                        } else if (table[xPos][yPos + 1] <= currentSize) {
                            q.add(new int[]{xPos, yPos + 1});
                            isVisited[xPos][yPos + 1] = isVisited[xPos][yPos] + 1;

                            if(table[xPos][yPos + 1] != 0 && table[xPos][yPos + 1] < currentSize) {
                                eatCandidate.add(new int[]{xPos, yPos + 1});
                            }
                        }
                    }
                }

                if(yPos - 1 >= 0) {
                    if(isVisited[xPos][yPos - 1] == -1) {
                        if(table[xPos][yPos - 1] == 0) {
                            q.add(new int[]{xPos, yPos - 1});
                            isVisited[xPos][yPos - 1] = isVisited[xPos][yPos] + 1;
                        } else if (table[xPos][yPos - 1] <= currentSize) {
                            q.add(new int[]{xPos, yPos - 1});
                            isVisited[xPos][yPos - 1] = isVisited[xPos][yPos] + 1;

                            if(table[xPos][yPos - 1] != 0 && table[xPos][yPos - 1] < currentSize) {
                                eatCandidate.add(new int[]{xPos, yPos - 1});
                            }
                        }
                    }
                }
            }

            List<int[]> minDistance = new ArrayList<>();
            if(eatCandidate.isEmpty()) {
                break;
            } else {
                int min = Integer.MAX_VALUE;

                for(int[] position : eatCandidate) {
                    min = Math.min(min, isVisited[position[0]][position[1]]);
                }

                for(int[] position : eatCandidate) {
                    if(isVisited[position[0]][position[1]] == min) {
                        minDistance.add(new int[]{position[0], position[1]});
                    }
                }

                minDistance.sort((o1, o2) -> {
                   if(o1[0] == o2[0]) {
                       return o1[1] - o2[1];
                   }

                   return o1[0] - o2[0];
                });

                int[] target = minDistance.get(0);

                time += isVisited[target[0]][target[1]];

                table[target[0]][target[1]] = 0;

                currentEat++;

                if(currentSize == currentEat) {
                    currentEat = 0;
                    currentSize += 1;
                }

                startX = target[0];
                startY = target[1];
            }
        }

        System.out.println(time);
    }
}
