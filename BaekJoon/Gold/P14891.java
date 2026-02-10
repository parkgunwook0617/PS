import java.io.*;
import java.util.*;

public class P14891 {
    public static int[][] chains = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int x = 0; x < 4; x++) {
            String line = br.readLine();

            for(int y = 0; y < 8; y++) {
                chains[x][y] = Character.getNumericValue(line.charAt(y));
            }
        }

        int rotateNumber = Integer.parseInt(br.readLine());
        for(int i = 0; i < rotateNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            checkAndRotate(target - 1, dir, 0);
        }

        int score = 0;
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                if(chains[i][0] == 1) {
                    score += 1;
                }
            } else if (i == 1) {
                if(chains[i][0] == 1) {
                    score += 2;
                }
            } else if (i == 2) {
                if(chains[i][0] == 1) {
                    score += 4;
                }
            } else if (i == 3) {
                if(chains[i][0] == 1) {
                    score += 8;
                }
            }
        }

        System.out.println(score);
    }

    public static void checkAndRotate(int target, int dir, int side) {
        if (side <= 0 && target > 0) {
            if (chains[target][6] != chains[target - 1][2]) {
                checkAndRotate(target - 1, -dir, -1);
            }
        }

        if (side >= 0 && target < 3) {
            if (chains[target][2] != chains[target + 1][6]) {
                checkAndRotate(target + 1, -dir, 1);
            }
        }


        rotate(target, dir);
    }

    public static void rotate(int target, int dir) {
        int temp;
        int[] targetChain = chains[target];

        if(dir == 1) {
            temp = targetChain[7];
            for(int i = 7; i > 0; i--) {
                targetChain[i] = targetChain[i - 1];
            }
            targetChain[0] = temp;
        } else if (dir == -1) {
            temp = targetChain[0];
            for(int i = 0; i < 7; i++) {
                targetChain[i] = targetChain[i + 1];
            }
            targetChain[7] = temp;
        }
    }
}
