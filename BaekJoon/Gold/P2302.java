import java.io.*;
import java.util.*;

public class P2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int seatNumber = Integer.parseInt(br.readLine());
        int specialSeatNumber = Integer.parseInt(br.readLine());
        int[] specialSeat = new int[specialSeatNumber];

        for(int i = 0; i < specialSeatNumber; i++) {
            specialSeat[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[seatNumber + 2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= seatNumber; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        if(specialSeatNumber == 0) {
            System.out.println(dp[seatNumber]);
            System.exit(0);
        }

        List<Integer> count = new ArrayList<>();
        int n = 1;
        for(int i = 0; i < specialSeatNumber; i++) {
            int counter = 0;
            while(true) {
                if(n == specialSeat[i]) {
                    count.add(counter);
                    n++;
                    break;
                } else {
                    n++;
                    counter++;
                }
            }
        }
        count.add(seatNumber - specialSeat[specialSeatNumber - 1]);


        long totalCase = 1;
        for(int i = 0; i < count.size(); i++) {
            if(dp[count.get(i)] == 0) {
                continue;
            }
            totalCase *= dp[count.get(i)];
        }

        System.out.println(totalCase);
    }
}
