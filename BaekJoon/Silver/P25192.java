import java.io.*;
import java.util.*;

public class P25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        int gomgomCount = 0;
        for(int i = 0; i < count; i++) {
            String command = br.readLine();

            if(command.equals("ENTER")) {
                set.clear();
            } else {
                if(set.add(command)) {
                    gomgomCount++;
                }
            }
        }

        System.out.println(gomgomCount);
    }
}
