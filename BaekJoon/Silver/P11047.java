import java.io.*;
import java.util.*;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long coinNumber = Long.parseLong(st.nextToken());
        long targetValue = Long.parseLong(st.nextToken());
        Stack<Long> stack = new Stack<>();

        for(long i = 0; i < coinNumber; i++) {
            stack.add(Long.parseLong(br.readLine()));
        }

        long neededNumber = 0;
        while(targetValue != 0) {
            long nextCoin = stack.pop();
            long divide = targetValue / nextCoin;
            long remainder = targetValue % nextCoin;

            neededNumber += divide;

            targetValue = remainder;
        }

        System.out.println(neededNumber);
    }
}
