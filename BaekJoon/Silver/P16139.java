import java.io.*;
import java.util.*;

public class P16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        long testcaseNumber = Long.parseLong(br.readLine());
        HashMap<Character, long[]> map = new HashMap<>();
        int length = sentence.length();

        for(int i = 0; i < length; i++) {
            char targetChar = sentence.charAt(i);

            if(map.get(targetChar) != null) {
                continue;
            } else {
                long[] table = new long[length];
                if(sentence.charAt(0) == targetChar) {
                    table[0] = 1;
                } else {
                    table[0] = 0;
                }

                for(int k = 1; k < length; k++) {
                    if(sentence.charAt(k) == targetChar) {
                        table[k] = table[k - 1] + 1;
                    } else {
                        table[k] = table[k - 1];
                    }
                }

                map.put(targetChar, table);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testcaseNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] table = map.getOrDefault(st.nextToken().charAt(0), new long[0]);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(table.length == 0) {
                sb.append(0).append("\n");
            } else if(start >= 1) {
                sb.append(table[end] - table[start - 1]).append("\n");
            } else {
                sb.append(table[end]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
