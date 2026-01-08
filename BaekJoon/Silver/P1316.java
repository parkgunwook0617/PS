import java.io.*;

public class P1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        String[] textArray = new String[inputCount];

        int nonGroup = 0;

        for(int i = 0; i < inputCount; i++) {
            textArray[i] = br.readLine();
        }

        for (int i = 0; i < inputCount; i++) {
            for(int j = 0; j < textArray[i].length(); j++) {
                for(int x = j+1; x < textArray[i].length(); x++) {
                    if(textArray[i].charAt(x-1) != textArray[i].charAt(x) && textArray[i].substring(x+1).contains(String.valueOf(textArray[i].charAt(x-1)))) {
                        nonGroup++;
                        break;
                    }
                }
                break;
            }
        }

        System.out.println(inputCount - nonGroup);
    }
}
