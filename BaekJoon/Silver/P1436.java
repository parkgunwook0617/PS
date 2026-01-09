import java.io.*;

public class P1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetCount = Integer.parseInt(br.readLine());
        int currentCount = 0;
        int number = 0;

        while(true) {
            if(String.valueOf(number).contains("666")) {
                currentCount++;
            }

            if(targetCount == currentCount) {
                break;
            }

            number++;
        }

        System.out.println(number);
    }
}
