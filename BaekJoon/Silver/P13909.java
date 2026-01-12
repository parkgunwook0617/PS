import java.io.*;

public class P13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long count = Long.parseLong(br.readLine());

        int targetSet = 0;
        for(int i = 0; i < (int)Math.sqrt(count); i++) {
            targetSet++;
        }

        System.out.println(targetSet);
    }
}
