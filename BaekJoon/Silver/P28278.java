import java.io.*;
import java.util.*;

public class P28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (command == 2) {
                if(!stack.empty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            } else if (command == 3) {
                System.out.println(stack.size());
            } else if (command == 4) {
                if(stack.empty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                if(!stack.empty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
