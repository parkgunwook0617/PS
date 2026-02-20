import java.io.*;
import java.util.*;

public class P1725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lineNumber = Integer.parseInt(br.readLine());
        long[] height = new long[lineNumber];

        for(int i = 0; i < lineNumber; i++) {
            height[i] = Long.parseLong(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        long max = height[0];
        stack.push(0);

        for (int i = 1; i <= lineNumber; i++) {
            long currentHeight = (i == lineNumber) ? 0 : height[i];

            while(!stack.isEmpty() && height[stack.peek()] > currentHeight) {
                long Height = height[stack.pop()];

                int limitRange = -1;

                if(!stack.isEmpty()) {
                    limitRange = stack.peek();
                }

                max = Math.max(max, Height * (i - 1 - limitRange));
            }

            stack.push(i);
        }

        System.out.println(max);
    }
}
