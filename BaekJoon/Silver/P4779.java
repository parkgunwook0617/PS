import java.io.*;
import java.util.*;

public class P4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            char[] targetString = new char[(int)Math.pow(3, Integer.parseInt(input))];
            Arrays.fill(targetString, '-');

            simulation(targetString, targetString.length, 0);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < targetString.length; i++) {
                if(targetString[i] == '-') {
                    sb.append('-');
                } else {
                    sb.append(' ');
                }
            }

            System.out.println(sb);
        }
    }

    public static void simulation(char[] targetString, int length, int startX) {
        if(length == 1) {
            return;
        }

        for(int i = length / 3 + startX; i < 2 * length / 3 + startX; i++) {
            targetString[i] = ' ';
        }

        simulation(targetString, length / 3, startX);
        simulation(targetString, length / 3, startX + (2 * length / 3));
    }
}
