import java.io.*;
import java.util.*;

public class P2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] space = new boolean[100][100];

        int totalSpace = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int x = a; x < a + 10; x++) {
                for(int y = b; y < b + 10; y++) {
                    space[x][y] = true;
                }
            }
        }

        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                if(space[x][y]) {
                    totalSpace++;
                }
            }
        }

        System.out.println(totalSpace);
    }
}
