import java.io.*;
import java.util.*;

public class P1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        char[][] candidate = new char[xSize][ySize];

        double minValue = Double.POSITIVE_INFINITY;
        double candidateNumber = 0;

        for(int x = 0; x < xSize; x++) {
            String line = br.readLine();

            for(int y = 0; y < ySize; y++) {
                candidate[x][y] = line.charAt(y);
            }
        }

        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                if(x + 8 > xSize || y + 8 > ySize) {
                    continue;
                }

                for(int i = x; i < x + 8; i++) {
                    for(int k = y; k < y + 8; k++) {
                        if((i + k) % 2 == 0) {
                            if(candidate[i][k] != 'B') {
                                candidateNumber++;
                            }
                        } else {
                            if(candidate[i][k] != 'W') {
                                candidateNumber++;
                            }
                        }
                    }
                }

                if(candidateNumber < minValue) {
                    minValue = candidateNumber;
                }

                candidateNumber = 0;

            }
        }

        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                if(x + 8 > xSize || y + 8 > ySize) {
                    continue;
                }

                for(int i = x; i < x + 8; i++) {
                    for(int k = y; k < y + 8; k++) {
                        if((i + k) % 2 == 0) {
                            if(candidate[i][k] != 'W') {
                                candidateNumber++;
                            }
                        } else {
                            if(candidate[i][k] != 'B') {
                                candidateNumber++;
                            }
                        }
                    }
                }

                if(candidateNumber < minValue) {
                    minValue = candidateNumber;
                }

                candidateNumber = 0;
            }
        }

        System.out.println((int)minValue);
    }
}
