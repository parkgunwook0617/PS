import java.io.*;
import java.util.*;

public class P15683 {
    public static int minNotCovered = Integer.MAX_VALUE;

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

        simulation(table, xSize, ySize, 0, 0);

        System.out.println(minNotCovered);
    }

    public static void simulation(int[][] table, int xSize, int ySize, int xPos, int yPos) {
        if(xPos == xSize) {
            int notCovered = 0;

            for(int x = 0; x < xSize; x++) {
                for(int y = 0; y < ySize; y++) {
                    if(table[x][y] == 0) {
                        notCovered++;
                    }
                }
            }

            minNotCovered = Math.min(minNotCovered, notCovered);
            return;
        }

        if(table[xPos][yPos] == 1) {
            int[][] dummyTable = new int[xSize][ySize];
            for(int k = 0; k < 4; k++) {
                for(int i = 0; i < xSize; i++) {
                    dummyTable[i] = table[i].clone();
                }

                if(k == 0) {
                    for(int x = xPos; x >= 0; x--) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 1) {
                    for(int y = yPos; y < ySize; y++) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 2) {
                    for(int x = xPos; x < xSize; x++) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 3) {
                    for(int y = yPos; y >= 0; y--) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                }
            }
        } else if (table[xPos][yPos] == 2) {
            int[][] dummyTable = new int[xSize][ySize];
            for(int k = 0; k < 2; k++) {
                for(int i = 0; i < xSize; i++) {
                    dummyTable[i] = table[i].clone();
                }

                if(k == 0) {
                    for(int x = xPos; x >= 0; x--) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    for(int x = xPos; x < xSize; x++) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 1) {
                    for(int y = yPos; y >= 0; y--) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    for(int y = yPos; y < ySize; y++) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                }
            }
        } else if (table[xPos][yPos] == 3) {
            int[][] dummyTable = new int[xSize][ySize];
            for(int k = 0; k < 4; k++) {
                for(int i = 0; i < xSize; i++) {
                    dummyTable[i] = table[i].clone();
                }

                if(k == 0) {
                    for(int x = xPos; x >= 0; x--) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    for(int y = yPos; y < ySize; y++) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 1) {
                    for(int y = yPos; y < ySize; y++) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    for(int x = xPos; x < xSize; x++) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 2) {
                    for(int x = xPos; x < xSize; x++) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    for(int y = yPos; y >= 0; y--) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 3) {
                    for(int y = yPos; y >= 0; y--) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    for(int x = xPos; x >= 0; x--) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                }
            }
        } else if (table[xPos][yPos] == 4) {
            int[][] dummyTable = new int[xSize][ySize];
            for(int k = 0; k < 4; k++) {
                for(int i = 0; i < xSize; i++) {
                    dummyTable[i] = table[i].clone();
                }

                if(k == 0) {
                    for(int x = xPos; x >= 0; x--) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    for(int y = yPos; y < ySize; y++) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    for(int y = yPos; y >= 0; y--) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 1) {
                    for(int y = yPos; y < ySize; y++) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    for(int x = xPos; x < xSize; x++) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    for(int x = xPos; x >= 0; x--) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 2) {
                    for(int x = xPos; x < xSize; x++) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    for(int y = yPos; y >= 0; y--) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    for(int y = yPos; y < ySize; y++) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                } else if (k == 3) {
                    for(int y = yPos; y >= 0; y--) {
                        if(dummyTable[xPos][y] == 6) {
                            break;
                        }

                        if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                            continue;
                        }

                        dummyTable[xPos][y] = 7;
                    }

                    for(int x = xPos; x >= 0; x--) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    for(int x = xPos; x < xSize; x++) {
                        if(dummyTable[x][yPos] == 6) {
                            break;
                        }

                        if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                            continue;
                        }

                        dummyTable[x][yPos] = 7;
                    }

                    if(yPos != ySize - 1) {
                        simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
                    } else {
                        simulation(dummyTable, xSize, ySize, xPos + 1, 0);
                    }
                }
            }
        } else if (table[xPos][yPos] == 5) {
            int[][] dummyTable = new int[xSize][ySize];

            for(int i = 0; i < xSize; i++) {
                dummyTable[i] = table[i].clone();
            }

            for(int y = yPos; y >= 0; y--) {
                if(dummyTable[xPos][y] == 6) {
                    break;
                }

                if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                    continue;
                }

                dummyTable[xPos][y] = 7;
            }

            for(int y = yPos; y < ySize; y++) {
                if(dummyTable[xPos][y] == 6) {
                    break;
                }

                if(dummyTable[xPos][y] == 1 || dummyTable[xPos][y] == 2 || dummyTable[xPos][y] == 3 || dummyTable[xPos][y] == 4 || dummyTable[xPos][y] == 5) {
                    continue;
                }

                dummyTable[xPos][y] = 7;
            }

            for(int x = xPos; x >= 0; x--) {
                if(dummyTable[x][yPos] == 6) {
                    break;
                }

                if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                    continue;
                }

                dummyTable[x][yPos] = 7;
            }

            for(int x = xPos; x < xSize; x++) {
                if(dummyTable[x][yPos] == 6) {
                    break;
                }

                if(dummyTable[x][yPos] == 1 || dummyTable[x][yPos] == 2 || dummyTable[x][yPos] == 3 || dummyTable[x][yPos] == 4 || dummyTable[x][yPos] == 5) {
                    continue;
                }

                dummyTable[x][yPos] = 7;
            }

            if(yPos != ySize - 1) {
                simulation(dummyTable, xSize, ySize, xPos, yPos + 1);
            } else {
                simulation(dummyTable, xSize, ySize, xPos + 1, 0);
            }
        } else {
            if(yPos != ySize - 1) {
                simulation(table, xSize, ySize, xPos, yPos + 1);
            } else {
                simulation(table, xSize, ySize, xPos + 1, 0);
            }
        }
    }
}
