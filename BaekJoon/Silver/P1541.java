import java.io.*;
import java.util.*;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();
        String[] splitPlus = sentence.split("-");
        List<Integer> collection = new ArrayList<>();

        for(int i = 0; i < splitPlus.length; i++) {
            String[] splitMinus = splitPlus[i].split("\\+");

            int sum = 0;
            for(int k = 0; k < splitMinus.length; k++) {
                sum += Integer.parseInt(splitMinus[k]);
            }

            collection.add(sum);
        }
        if(collection.size() == 1) {
            System.out.println(collection.get(0));
        } else {
            int totalSum = collection.get(0);
            for(int i = 1; i < collection.size(); i++) {
                totalSum -= collection.get(i);
            }

            System.out.println(totalSum);
        }
    }
}
