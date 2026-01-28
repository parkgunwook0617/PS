import java.io.*;

public class P9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence1 = br.readLine();
        String sentence2 = br.readLine();

        int[][] tableForNumber = new int[sentence1.length()][sentence2.length()];
        String[][] tableForString = new String[sentence1.length()][sentence2.length()];;

        for(int x = 0; x < sentence1.length(); x++) {
            if(sentence1.charAt(x) == sentence2.charAt(0)) {
                tableForNumber[x][0] = 1;
                tableForString[x][0] = "CROSS";
            } else if (x > 0 && tableForNumber[x-1][0] == 1) {
                tableForNumber[x][0] = 1;
                tableForString[x][0] = "UP";
            }
        }

        for(int y = 0; y < sentence2.length(); y++) {
            if(sentence2.charAt(y) == sentence1.charAt(0)) {
                tableForNumber[0][y] = 1;
                tableForString[0][y] = "CROSS";
            } else if (y > 0 && tableForNumber[0][y-1] == 1) {
                tableForNumber[0][y] = 1;
                tableForString[0][y] = "LEFT";
            }
        }

        for(int x = 1; x < sentence1.length(); x++) {
            for(int y = 1; y < sentence2.length(); y++) {
                if(sentence1.charAt(x) == sentence2.charAt(y)) {
                    tableForNumber[x][y] = tableForNumber[x - 1][y - 1] + 1;
                    tableForString[x][y] = "CROSS";
                } else if (tableForNumber[x - 1][y] >= tableForNumber[x][y - 1]) {
                    tableForNumber[x][y] = tableForNumber[x - 1][y];
                    tableForString[x][y] = "UP";
                } else {
                    tableForNumber[x][y] = tableForNumber[x][y - 1];
                    tableForString[x][y] = "LEFT";
                }
            }
        }

        int step = tableForNumber[sentence1.length() - 1][sentence2.length() - 1];
        int currentX = sentence1.length() - 1;
        int currentY = sentence2.length() - 1;
        String sentence = "";
        while(step != 0) {
            if(tableForString[currentX][currentY].equals("CROSS")) {
                sentence = sentence1.charAt(currentX) + sentence;
                currentX--;
                currentY--;
                step--;
            } else if (tableForString[currentX][currentY].equals("UP")) {
                currentX--;
            } else {
                currentY--;
            }
        }

        System.out.println(tableForNumber[sentence1.length() - 1][sentence2.length() - 1]);
        if(tableForNumber[sentence1.length() - 1][sentence2.length() - 1] == 0) {
            System.exit(0);
        }
        System.out.println(sentence);
    }
}
