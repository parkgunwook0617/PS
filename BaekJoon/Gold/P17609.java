import java.io.*;
import java.util.*;

public class P17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sentenceNumber = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sentenceNumber; i++) {
            StringBuilder sentence = new StringBuilder(br.readLine());
            boolean isAlready = false;

            if(sentence.toString().equals(new StringBuilder(sentence).reverse().toString())) {
                sb.append(0).append("\n");
                continue;
            }

            if(check(sentence, 0, sentence.length() - 1, 0)) {
                isAlready = true;
                sb.append(1).append("\n");
            }


            if(!isAlready) {
                sb.append(2).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean check(StringBuilder sentence, int left, int right, int deleteCount) {
        if(deleteCount >= 2) {
            return false;
        }

        while(left < right) {
            if(sentence.charAt(left) == sentence.charAt(right)) {
                left++;
                right--;
            } else {
                return check(sentence, left + 1, right, deleteCount + 1) || check(sentence, left, right - 1, deleteCount + 1);
            }
        }

        return true;
    }
}
