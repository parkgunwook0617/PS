import java.io.*;
import java.util.*;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < commandCount; i++) {
            String nextString = br.readLine();

            Stack<Character> stack = new Stack<Character>();
            for(int x = 0; x < nextString.length(); x++) {
                stack.push(nextString.charAt(x));
            }

            int countClose = 0;
            for(int y = 0; y < nextString.length(); y++) {
                char nextValue = stack.pop();

                if(nextValue == '(') {
                    if(countClose == 0) {
                        countClose = -1;
                        break;
                    }

                    countClose--;
                } else if (nextValue == ')') {
                    countClose++;
                }
            }

            if(countClose == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
