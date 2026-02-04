import java.io.*;
import java.util.*;

public class P14500 {
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

        int maxScore = Integer.MIN_VALUE;
        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                if(x + 3 < xSize) {
                    maxScore = Math.max(maxScore, table[x][y] + table[x + 1][y] + table[x + 2][y] + table[x + 3][y]);
                }

                if(y + 3 < ySize) {
                    maxScore = Math.max(maxScore, table[x][y] + table[x][y + 1] + table[x][y + 2] + table[x][y + 3]);
                }

                if(x + 1 < xSize) {
                    if(y + 1 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x + 1][y] + table[x][y + 1] + table[x + 1][y + 1]);
                    }
                }

                if(x + 2 < xSize) {
                    if(y + 1 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x + 1][y] + table[x + 2][y] + table[x + 2][y + 1]);
                        maxScore = Math.max(maxScore, table[x][y] + table[x][y + 1] + table[x + 1][y + 1] + table[x + 2][y + 1]);
                    }
                }

                if(x + 1 < xSize) {
                    if(y + 2 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x + 1][y] + table[x][y + 1] + table[x][y + 2]);
                    }
                }

                if(x - 1 >= 0) {
                    if(y + 2 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x][y + 1] + table[x][y + 2] + table[x - 1][y + 2]);
                    }
                }

                if(x + 2 < xSize) {
                    if(y + 1 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x + 1][y] + table[x + 1][y + 1] + table[x + 2][y + 1]);
                    }
                }

                if(x + 1 < xSize) {
                    if(y + 2 < ySize) {
                        maxScore = Math.max(maxScore, table[x + 1][y] + table[x + 1][y + 1] + table[x][y + 1] + table[x][y + 2]);
                    }
                }

                if(x + 1 < xSize) {
                    if(y + 2 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x][y + 1] + table[x][y + 2] + table[x + 1][y + 1]);
                    }
                }
                if(x + 2 < xSize) {
                    if(y + 1 < ySize) {
                        maxScore = Math.max(maxScore, table[x + 1][y] + table[x][y + 1] + table[x + 1][y + 1] + table[x + 2][y + 1]);
                    }
                }

                if(x - 1 >= 0) {
                    if(y + 2 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x][y + 1] + table[x][y + 2] + table[x - 1][y + 1]);
                    }
                }

                if(x + 2 < xSize) {
                    if(y + 1 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x + 1][y] + table[x + 2][y] + table[x + 1][y + 1]);
                    }
                }

                if(x + 2 < xSize) {
                    if(y + 1 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y + 1] + table[x + 1][y + 1] + table[x + 1][y] + table[x + 2][y]);
                    }
                }

                if(x + 1 < xSize) {
                    if(y + 2 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x][y + 1] + table[x + 1][y + 1] + table[x + 1][y + 2]);
                    }
                }

                if(x + 2 < xSize) {
                    if(y + 1 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y + 1] + table[x + 1][y + 1] + table[x + 2][y + 1] + table[x + 2][y]);
                    }
                }

                if(x + 1 < xSize) {
                    if(y + 2 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x][y + 1] + table[x][y + 2] + table[x + 1][y + 2]);
                    }
                }

                if(x + 1 < xSize) {
                    if(y + 2 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x + 1][y] + table[x + 1][y + 1] + table[x + 1][y + 2]);
                    }
                }

                if(x + 2 < xSize) {
                    if(y + 1 < ySize) {
                        maxScore = Math.max(maxScore, table[x][y] + table[x][y + 1] + table[x + 1][y] + table[x + 2][y]);
                    }
                }
            }
        }

        System.out.println(maxScore);
    }
}
