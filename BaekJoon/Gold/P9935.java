import java.io.*;
import java.util.*;

public class P9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String targetWord = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Character> spare = new Stack<>();

        for(int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);

            stack.add(current);

            if(current == targetWord.charAt(targetWord.length() - 1)) {
                boolean isTarget = true;
                int step = targetWord.length() - 1;

                if(stack.size() < targetWord.length()) {
                    isTarget = false;
                }

                for(int k = 0;  k < targetWord.length(); k++) {
                    if(!stack.empty()) {
                        char data = stack.pop();

                        if(data == targetWord.charAt(step--)) {
                            spare.add(data);
                        } else {
                            isTarget = false;
                            spare.add(data);
                        }
                    }
                }

                if(isTarget) {
                    spare.clear();
                } else {
                    while(!spare.empty()) {
                        stack.add(spare.pop());
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) {
            sb.append("ALURF");
        } else {
            while(!stack.empty()) {
                sb.append(stack.pop());
            }

        }

        System.out.println(sb.reverse());
    }
}
