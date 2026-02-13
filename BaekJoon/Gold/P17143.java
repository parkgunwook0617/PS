import java.io.*;
import java.util.*;

public class P17143 {
    public static class Shark implements Comparable<Shark> {
        int speed;
        int movDirection;
        int size;
        boolean isMoved = false;

        Shark(int speed, int movDirection, int size) {
            this.speed = speed;
            this.movDirection = movDirection;
            this.size = size;
        }

        @Override
        public int compareTo(Shark o) {
            return Integer.compare(this.size, o.size);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        int sharkNumber = Integer.parseInt(st.nextToken());

        Shark[][] table = new Shark[xSize + 1][ySize + 1];

        for(int i = 0; i < sharkNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int xPos = Integer.parseInt(st.nextToken());
            int yPOs = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int movDirection = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            table[xPos][yPOs] = new Shark(speed, movDirection, size);
        }

        int userPos = 1;
        int totalSize = 0;
        while(userPos != ySize + 1) {
            for (int x = 1; x <= xSize; x++) {
                if (table[x][userPos] != null) {
                    totalSize += table[x][userPos].size;
                    table[x][userPos] = null;
                    break;
                }
            }

            Shark[][] nextTable = new Shark[xSize + 1][ySize + 1];

            for(int x = 1; x <= xSize; x++) {
                for(int y = 1; y <= ySize; y++) {
                    if(table[x][y] != null) {
                        Shark currentShark = table[x][y];

                        int speed = currentShark.speed;
                        int movDirection = currentShark.movDirection;

                        if(movDirection == 1 || movDirection == 2) {
                            int realSpeed = speed % (2 * (xSize - 1));
                            int xPos = x;
                            for (int i = 0; i < realSpeed; i++) {
                                if(xPos == 1) {
                                    currentShark.movDirection = 2;
                                } else if (xPos == xSize) {
                                    currentShark.movDirection = 1;
                                }

                                if(currentShark.movDirection == 1) {
                                    xPos -= 1;
                                } else if (currentShark.movDirection == 2) {
                                    xPos += 1;
                                }
                            }

                            if(nextTable[xPos][y] != null) {
                                if(currentShark.size > nextTable[xPos][y].size) {
                                    nextTable[xPos][y] = currentShark;
                                }
                            } else {
                                nextTable[xPos][y] = currentShark;
                            }
                        } else if (movDirection == 3 || movDirection == 4) {
                            int realSpeed = speed % (2 * (ySize - 1));
                            int yPos = y;
                            for (int i = 0; i < realSpeed; i++) {
                                if(yPos == 1) {
                                    currentShark.movDirection = 3;
                                } else if (yPos == ySize) {
                                    currentShark.movDirection = 4;
                                }

                                if(currentShark.movDirection == 3) {
                                    yPos += 1;
                                } else if (currentShark.movDirection == 4) {
                                    yPos -= 1;
                                }
                            }

                            if(nextTable[x][yPos] != null) {
                                if(currentShark.size > nextTable[x][yPos].size) {
                                    nextTable[x][yPos] = currentShark;
                                }
                            } else {
                                nextTable[x][yPos] = currentShark;
                            }
                        }
                    }
                }
            }

            table = nextTable;
            userPos++;
        }

        System.out.println(totalSize);
    }
}
