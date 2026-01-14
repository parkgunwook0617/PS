import java.io.*;
import java.util.*;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 1; i <= cardCount; i++) {
            q.add(i);
        }

        while(q.size() != 1) {
            q.remove();
            int changedValue = q.poll();
            q.add(changedValue);
        }

        System.out.println(q.poll());
    }
}
