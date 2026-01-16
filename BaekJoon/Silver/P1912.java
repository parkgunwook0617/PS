import java.io.*;
import java.util.*;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());
        long[] numberCollection = new long[numberCount];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < numberCount; i++) {
            numberCollection[i] = Long.parseLong(st.nextToken());
        }

        long max = Long.MIN_VALUE;
        long candidateNumber = 0;
        for(int i = 0; i < numberCount; i++) {
            candidateNumber += numberCollection[i];

            if(candidateNumber < 0) {
                max = Math.max(max, candidateNumber);
                candidateNumber = 0;
                continue;
            }

            max = Math.max(max, candidateNumber);
        }

        System.out.println(max);
    }
}
