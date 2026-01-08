import java.io.*;

public class P1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetNumber = Integer.parseInt(br.readLine());
        int counter = 0;
        int total = 0;
        while(true) {
            total += counter;

            if(total >= targetNumber) {
                break;
            }

            counter++;
        }

        int rangeStart = total - counter + 1;
        if(counter % 2 == 0) {
            System.out.println((1 + (targetNumber - rangeStart)) + "/" + (counter - (targetNumber - rangeStart)));
        } else {
            System.out.println((counter - (targetNumber - rangeStart)) + "/" + (1 + (targetNumber - rangeStart)));
        }
    }
}
