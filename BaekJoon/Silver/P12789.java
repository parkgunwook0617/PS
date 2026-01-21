import java.io.*;
import java.util.*;

public class P12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        int count = 1;

        for(int i = 0; i < number; i++) {
            int nextValue = Integer.parseInt(st.nextToken());
            if (nextValue > count) {
                stack.push(nextValue);
            } else if (nextValue == count) {
                count++;
            }

            while (!stack.isEmpty() && stack.peek() == count) {
                stack.pop();
                count++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
