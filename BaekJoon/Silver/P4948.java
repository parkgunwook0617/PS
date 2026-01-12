import java.io.*;

public class P4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int value = Integer.parseInt(br.readLine());
            if(value == 0) {
                break;
            }

            int count = 0;
            for(int x = value + 1; x <= 2 * value; x++) {
                boolean isPrime = true;

                for(int y = 2; y * y <= x; y++) {
                    if(x % y == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if(isPrime) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
