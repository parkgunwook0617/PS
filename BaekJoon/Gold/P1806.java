import java.io.*;
import java.util.*;

public class P1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] numberList = new int[number];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < number; i++) {
            numberList[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;
        while(true) {
            if (sum >= target) {
                if(end - start < length) {
                    length = end - start;
                }

                sum -= numberList[start];
                start++;
            } else if (end == number) {
                break;
            } else {
                sum += numberList[end];
                end++;
            }
        }

        if(length == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(length);
        }
    }
}
