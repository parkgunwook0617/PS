import java.io.*;
import java.util.*;

public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String sentence = br.readLine();

            if(sentence.equals(".")) {
                break;
            }

            boolean isTrue = true;
            Stack<Character> stack = new Stack<Character>();
            for(int i = 0; i < sentence.length(); i++) {
                if(sentence.charAt(i) == '(') {
                    stack.push('(');
                } else if (sentence.charAt(i) == ')') {
                    if(stack.empty()) {
                        stack.push(')');
                    } else {
                        if(stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(')');
                        }
                    }
                }

                if(sentence.charAt(i) == '[') {
                    stack.push('[');
                } else if (sentence.charAt(i) == ']') {
                    if(stack.empty()) {
                        stack.push(']');
                    } else {
                        if(stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(']');
                        }
                    }
                }
            }

            if(stack.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
