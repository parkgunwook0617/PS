import java.io.*;

public class P4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        long[] candidate = new long[count];
        for(int i = 0; i < count; i++) {
            candidate[i] = Long.parseLong(br.readLine());
        }

        for(int x = 0; x < count; x++) {
            boolean isFind = true;
            for(long y = candidate[x]; ;y++) {
                if(y == 0 || y == 1 || y == 2) {
                    System.out.println(2);
                    break;
                }

                for(long z = 2; z * z <= y; z++) {
                    if(y % z == 0 && y != z) {
                        isFind = false;
                        break;
                    }
                }

                if(isFind) {
                    System.out.println(y);
                    break;
                }

                isFind = true;
            }
        }
    }
}
