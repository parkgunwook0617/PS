import java.io.*;
import java.util.*;

public class P1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int monsterCount = Integer.parseInt(st.nextToken());
        int commandCount = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numToName = new HashMap<Integer, String>();
        HashMap<String, Integer> nameToNum = new HashMap<String, Integer>();

        for(int i = 0; i < monsterCount; i++) {
            String name = br.readLine();

            numToName.put(i + 1, name);
            nameToNum.put(name, i + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < commandCount; i++) {
            String command = br.readLine();

            if(Character.isDigit(command.charAt(0))) {
                sb.append(numToName.get(Integer.parseInt(command))).append("\n");
            } else {
                sb.append(nameToNum.get(command)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
