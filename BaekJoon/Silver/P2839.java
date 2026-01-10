import java.io.*;

public class P2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetWeight = Integer.parseInt(br.readLine());

        int num5 = targetWeight / 5;
        int rest = targetWeight % 5;

        while(true) {
            if(rest % 3 != 0) {
                if(num5 == 0) {
                    System.out.println(-1);
                    return;
                }
                num5--;
                rest += 5;
            } else {
                break;
            }
        }

        System.out.println(num5 + (rest / 3));
    }
}
