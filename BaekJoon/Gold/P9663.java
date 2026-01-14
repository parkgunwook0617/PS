import java.io.*;

public class P9663 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        boolean[][] table = new boolean[size][size];

        simulation(table, size, 0);

        System.out.println(count);
    }

    public static void simulation(boolean[][] table, int size, int present) {
        if(present == size) {
            count++;
            return;
        }

        for(int i = 0; i < size; i++) {
            boolean isTrue = true;

            if(!table[present][i]) {
                for(int x = 0; x < present; x++) {
                   if(table[x][i]) {
                       isTrue = false;
                       break;
                   }
                }

                for(int y = 0; y < present; y++) {
                    if(table[present][y]) {
                        isTrue = false;
                        break;
                    }
                }

                for(int x = present, y = i; x >= 0 && y >= 0; x--, y--) {
                    if(table[x][y]) {
                        isTrue = false;
                        break;
                    }
                }

                for(int x = present, y = i; x >= 0 && y < size; x--, y++) {
                    if(table[x][y]) {
                        isTrue = false;
                        break;
                    }
                }

                if(isTrue) {
                    table[present][i] = true;
                    simulation(table, size, present + 1);
                    table[present][i] = false;
                }
            }
        }
    }
}
