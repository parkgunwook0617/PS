import java.io.*;
import java.util.*;

public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < count; i++) {
            int value = Integer.parseInt(br.readLine());

            if(value == 0) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
