import java.io.*;
import java.util.*;

public class P13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long numA = Long.parseLong(st.nextToken());
        long numB = Long.parseLong(st.nextToken());

        if(numB > numA) {
            long middle = numA;
            numA = numB;
            numB = middle;
        }

        long originalNumA = numA;
        long originalNumB = numB;

        long finalValue;
        while(true) {
            finalValue = numA % numB;
            if(finalValue == 0) {
                finalValue = numB;
                break;
            }
            numA = numB;
            numB = finalValue;
        }

        System.out.println(originalNumA * originalNumB / finalValue);
    }
}
