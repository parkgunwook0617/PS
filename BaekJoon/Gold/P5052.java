import java.io.*;
import java.util.*;

public class P5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());

        while(testcaseNumber != 0) {
            int phoneNumber = Integer.parseInt(br.readLine());
            String[] phone = new String[phoneNumber];

            for(int i = 0; i < phoneNumber; i++) {
                phone[i] = br.readLine();
            }

            boolean consistency = true;

            Arrays.sort(phone);

            for(int i = 0; i < phoneNumber - 1; i++) {
                if(phone[i + 1].startsWith(phone[i])) {
                    consistency = false;
                }

                if(!consistency) {
                    break;
                }
            }

            if(consistency) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            testcaseNumber--;
        }
    }
}
