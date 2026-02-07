import java.io.*;
import java.util.*;

public class P2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        double[][] line = new double[size][2];
        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i][0] = Double.parseDouble(st.nextToken());
            line[i][1] = Double.parseDouble(st.nextToken());
        }

        double front = 0;
        for(int i = 0; i < size - 1; i++) {
            front += line[i][0] * line[i + 1][1];
        }

        double back = 0;
        for(int i = 0; i < size - 1; i++) {
            back += line[i][1] * line[i + 1][0];
        }

        front += line[size - 1][0] * line[0][1];
        back += line[size - 1][1] * line[0][0];

        System.out.printf("%.1f", Math.abs(front - back) / 2);
    }
}
