import java.io.*;
import java.util.*;

public class P14889 {
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] table = new int[size + 1][size + 1];

        for(int x = 1; x <= size; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int y = 1; y <= size; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] teamStart = new boolean[size + 1];

        simulation(teamStart, 0, size, 1, table);

        System.out.println(min);
    }

    public static void simulation(boolean[] teamStart, int number, int size, int start, int[][] table) {
        if(number == size / 2) {
            List<Integer> teamS = new ArrayList<>();
            List<Integer> teamL = new ArrayList<>();

            for(int x = 1; x <= size; x++) {
                if(teamStart[x]) {
                    teamS.add(x);
                } else {
                    teamL.add(x);
                }
            }

            int sumS = 0;
            int sumL = 0;

            for(int x = 0; x < teamS.size(); x++) {
                int person1 = teamS.get(x);

                for(int y = 0; y < teamS.size(); y++) {
                    int person2 = teamS.get(y);

                    sumS += table[person1][person2];
                }
            }

            for(int x = 0; x < teamL.size(); x++) {
                int person1 = teamL.get(x);

                for(int y = 0; y < teamL.size(); y++) {
                    int person2 = teamL.get(y);

                    sumL += table[person1][person2];
                }
            }

            if(Math.abs(sumS - sumL) < min) {
                min = Math.abs(sumS - sumL);
            }

            return;
        }

        for (int i = start; i <= size; i++) {
            if (!teamStart[i]) {
                teamStart[i] = true;
                simulation(teamStart, number + 1, size, i + 1, table);
                teamStart[i] = false;
            }
        }
    }
}
