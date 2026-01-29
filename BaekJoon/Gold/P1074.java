import java.io.*;
import java.util.*;

public class P1074 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        simulation(size, 0, 0, targetX, targetY);
    }

    public static void simulation(int size, int xPos, int yPos, int targetX, int targetY) {
        if (!(targetX >= xPos && targetX < xPos + size && targetY >= yPos && targetY < yPos + size)) {
            count += size * size;
            return;
        }

        if(size == 2) {
            for(int x = xPos; x < xPos + 2; x++) {
                for(int y = yPos; y < yPos + 2; y++) {
                    if(x == targetX && y == targetY) {
                        System.out.println(count);
                        System.exit(0);
                    }

                    count++;
                }
            }
            return;
        }

        simulation(size / 2, xPos, yPos, targetX, targetY);
        simulation(size / 2, xPos, yPos + size / 2, targetX, targetY);
        simulation(size / 2, xPos + size / 2, yPos, targetX, targetY);
        simulation(size / 2, xPos + size / 2, yPos + size / 2, targetX, targetY);
    }
}
