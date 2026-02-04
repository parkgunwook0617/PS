import java.io.*;
import java.util.*;

public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testcaseNumber != 0) {
            String order = br.readLine();
            String size = br.readLine();

            String wordSet = br.readLine();
            wordSet = wordSet.replace("[", "");
            wordSet = wordSet.replace("]", "");
            String[] finalWordSet = wordSet.split(",");

            Deque<Integer> collection = new ArrayDeque<>();
            for(String num : finalWordSet) {
                if(num.equals("")) {
                    continue;
                }

                collection.add(Integer.parseInt(num));
            }

            boolean isError = false;
            boolean isReversed = false;
            for(int i = 0; i < order.length(); i++) {
                char currentOrder = order.charAt(i);

                if(currentOrder == 'R') {
                    isReversed = !isReversed;
                } else {
                    if(collection.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if(isReversed) {
                        collection.pollLast();
                    } else {
                        collection.pollFirst();
                    }
                }
            }

            if(isError) {
                sb.append("error").append("\n");
            } else {
                if(isReversed) {
                    sb.append('[');

                    while(!collection.isEmpty()) {
                        sb.append(collection.pollLast());

                        if (!collection.isEmpty()) {
                            sb.append(',');
                        }
                    }

                    sb.append(']').append("\n");
                } else {
                    sb.append('[');

                    while(!collection.isEmpty()) {
                        sb.append(collection.pollFirst());

                        if (!collection.isEmpty()) {
                            sb.append(',');
                        }
                    }

                    sb.append(']').append("\n");
                }
            }

            testcaseNumber--;
        }

        System.out.println(sb);
    }
}
