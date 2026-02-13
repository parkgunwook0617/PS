import java.io.*;

public class P12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while(T.length() != S.length()) {
            if(T.endsWith("A")) {
                T = T.substring(0, T.length() - 1);
            } else if (T.endsWith("B")){
                T = T.substring(0, T.length() - 1);
                T = new StringBuilder(T).reverse().toString();
            }
        }

        if(T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
