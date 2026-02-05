import java.io.*;
import java.util.*;

public class P1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stackOperator = new Stack<>();
        for(int i = 0; i < sentence.length(); i++) {
            char target = sentence.charAt(i);

            if(target != '+' && target != '-' && target != '*' && target != '/' && target != '(' && target != ')') {
                sb.append(target);
            } else {
                if(target == '(') {
                    stackOperator.push(target);
                } else if (target == ')') {
                    while(!stackOperator.empty() && stackOperator.peek() != '(') {
                        sb.append(stackOperator.pop());
                    }

                    stackOperator.pop();
                } else {
                    while (!stackOperator.isEmpty() && priority(stackOperator.peek()) >= priority(target)) {
                        sb.append(stackOperator.pop());
                    }
                    stackOperator.push(target);
                }
            }
        }

        while(!stackOperator.empty()) {
            sb.append(stackOperator.pop());
        }

        System.out.println(sb);
    }

    public static int priority(char op) {
        if (op == '(') return 0;
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }
}
