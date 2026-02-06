import java.io.*;
import java.util.*;

public class P14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        int[][] table = new int[xSize][ySize];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startDirection = Integer.parseInt(st.nextToken());

        for(int x = 0; x < xSize; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < ySize; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(table, xSize, ySize, startX, startY, startDirection);
    }

    public static void simulation(int[][] table, int xSize, int ySize, int startX, int startY, int currentDirection) {
        if(table[startX][startY] == 0) {
            table[startX][startY] = 2;
        }

        if((startX + 1 < xSize && table[startX + 1][startY] == 0) || (startX - 1 >= 0 && table[startX - 1][startY] == 0) || (startY + 1 < ySize && table[startX][startY + 1] == 0) || (startY - 1 >= 0 && table[startX][startY - 1] == 0)) {
            currentDirection--;
            while(true) {
                if(currentDirection == -1) {
                    currentDirection = 3;
                }

                if(currentDirection == 0) {
                    if(startX - 1 >= 0) {
                        if(table[startX - 1][startY] == 0) {
                            break;
                        } else {
                            currentDirection--;
                        }
                    }
                }

                if (currentDirection == 1) {
                    if(startY + 1 < ySize) {
                        if(table[startX][startY + 1] == 0) {
                            break;
                        } else {
                            currentDirection--;
                        }
                    }
                }

                if (currentDirection == 2) {
                    if(startX + 1 < xSize) {
                        if(table[startX + 1][startY] == 0) {
                            break;
                        } else {
                            currentDirection--;
                        }
                    }
                }

                if (currentDirection == 3) {
                    if(startY - 1 >= 0) {
                        if(table[startX][startY - 1] == 0) {
                            break;
                        } else {
                            currentDirection--;
                        }
                    }
                }
            }

            if(currentDirection == 0) {
                if(startX - 1 >= 0) {
                    if(table[startX - 1][startY] == 0) {
                        simulation(table, xSize, ySize, startX - 1, startY, currentDirection);
                    }
                }
            } else if (currentDirection == 1) {
                if(startY + 1 < ySize) {
                    if(table[startX][startY + 1] == 0) {
                        simulation(table, xSize, ySize, startX, startY + 1, currentDirection);
                    }
                }
            } else if (currentDirection == 2) {
                if(startX + 1 < xSize) {
                    if(table[startX + 1][startY] == 0) {
                        simulation(table, xSize, ySize, startX + 1, startY, currentDirection);
                    }
                }
            } else if (currentDirection == 3) {
                if(startY - 1 >= 0) {
                    if(table[startX][startY - 1] == 0) {
                        simulation(table, xSize, ySize, startX, startY - 1, currentDirection);
                    }
                }
            }
        } else {
            if(currentDirection == 0) {
                if(startX + 1 < xSize) {
                    if(table[startX + 1][startY] != 1) {
                        simulation(table, xSize, ySize, startX + 1, startY, currentDirection);
                    } else {
                        int washedArea = 0;
                        for(int x = 0; x < xSize; x++) {
                            for(int y = 0; y < ySize; y++) {
                                if(table[x][y] == 2) {
                                    washedArea++;
                                }
                            }
                        }

                        System.out.println(washedArea);
                        System.exit(0);
                    }
                }
            } else if (currentDirection == 1) {
                if(startY - 1 >= 0) {
                    if(table[startX][startY - 1] != 1) {
                        simulation(table, xSize, ySize, startX, startY - 1, currentDirection);
                    } else {
                        int washedArea = 0;
                        for(int x = 0; x < xSize; x++) {
                            for(int y = 0; y < ySize; y++) {
                                if(table[x][y] == 2) {
                                    washedArea++;
                                }
                            }
                        }

                        System.out.println(washedArea);
                        System.exit(0);
                    }
                }
            } else if (currentDirection == 2) {
                if(startX - 1 >= 0) {
                    if(table[startX - 1][startY] != 1) {
                        simulation(table, xSize, ySize, startX - 1, startY, currentDirection);
                    } else {
                        int washedArea = 0;
                        for(int x = 0; x < xSize; x++) {
                            for(int y = 0; y < ySize; y++) {
                                if(table[x][y] == 2) {
                                    washedArea++;
                                }
                            }
                        }

                        System.out.println(washedArea);
                        System.exit(0);
                    }
                }
            } else if (currentDirection == 3) {
                if(startY + 1 < ySize) {
                    if(table[startX][startY + 1] != 1) {
                        simulation(table, xSize, ySize, startX, startY + 1, currentDirection);
                    } else {
                        int washedArea = 0;
                        for(int x = 0; x < xSize; x++) {
                            for(int y = 0; y < ySize; y++) {
                                if(table[x][y] == 2) {
                                    washedArea++;
                                }
                            }
                        }

                        System.out.println(washedArea);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
