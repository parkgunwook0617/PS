import java.io.*;
import java.util.*;

public class P2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] collection = new int[count];

        for(int i = 0; i < count; i++) {
            collection[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(collection);

        for(int i = 0; i < count; i++) {
            System.out.println(collection[i]);
        }
    }
}
