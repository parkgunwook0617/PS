import java.io.*;
import java.util.*;

public class P2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseNumber = Integer.parseInt(st.nextToken());
        int shareNumber = Integer.parseInt(st.nextToken());

        int[] house = new int[houseNumber];

        for(int i = 0; i < houseNumber; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 0;
        int right = house[houseNumber - 1];
        int distance = 0;
        while(left <= right) {
            int houseCount = 1;
            int testDistance = (left + right) / 2;
            int start = house[0];

            for(int i = 0; i < houseNumber; i++) {
                if(start + testDistance <= house[i]) {
                    houseCount++;
                    start = house[i];
                }
            }

            if(houseCount >= shareNumber) {
                distance = testDistance;
                left = testDistance + 1;
            } else {
                right = testDistance - 1;
            }
        }

        System.out.println(distance);
    }
}
