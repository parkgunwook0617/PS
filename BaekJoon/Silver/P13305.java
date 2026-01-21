import java.io.*;
import java.util.*;

public class P13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityNumber = Integer.parseInt(br.readLine());
        long[] distance = new long[cityNumber - 1];
        long[] oilPrice = new long[cityNumber - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cityNumber - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cityNumber - 1; i++) {
            oilPrice[i] = Long.parseLong(st.nextToken());
        }

        long startOil = oilPrice[0];
        long usedMoney = 0;
        for(int i = 0; i < cityNumber - 1; i++) {
            if(startOil > oilPrice[i]) {
                startOil = oilPrice[i];
                usedMoney += distance[i] * startOil;
            } else {
                usedMoney += distance[i] * startOil;
            }
        }

        System.out.println(usedMoney);
    }
}
