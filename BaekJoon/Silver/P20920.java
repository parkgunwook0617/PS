import java.io.*;
import java.util.*;

public class P20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wordCount = Integer.parseInt(st.nextToken());
        int wordLength = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();
            if (word.length() >= wordLength) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());

        words.sort((o1, o2) -> {
            if (!map.get(o1).equals(map.get(o2))) {
                return map.get(o2) - map.get(o1);
            }
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }

            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
