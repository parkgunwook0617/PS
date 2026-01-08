import java.io.*;

public class P25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] subjectHakjum = new double[20];
        String[] subjectRank = new String[20];

        double totalScore = 0;
        double totalHakjum = 0;

        for(int i = 0; i < 20; i++) {
            String subjectInformation = br.readLine();
            subjectHakjum[i] = Double.parseDouble(subjectInformation.split(" ")[1]);
            subjectRank[i] = subjectInformation.split(" ")[2];
        }

        for(int i = 0; i < 20; i++) {
            if(subjectRank[i].equals("A+")) {
                totalScore += subjectHakjum[i] * 4.5;
                totalHakjum += subjectHakjum[i];
            } else if (subjectRank[i].equals("A0")) {
                totalScore += subjectHakjum[i] * 4.0;
                totalHakjum += subjectHakjum[i];
            } else if (subjectRank[i].equals("B+")) {
                totalScore += subjectHakjum[i] * 3.5;
                totalHakjum += subjectHakjum[i];
            } else if (subjectRank[i].equals("B0")) {
                totalScore += subjectHakjum[i] * 3.0;
                totalHakjum += subjectHakjum[i];
            } else if (subjectRank[i].equals("C+")) {
                totalScore += subjectHakjum[i] * 2.5;
                totalHakjum += subjectHakjum[i];
            } else if (subjectRank[i].equals("C0")) {
                totalScore += subjectHakjum[i] * 2.0;
                totalHakjum += subjectHakjum[i];
            } else if (subjectRank[i].equals("D+")) {
                totalScore += subjectHakjum[i] * 1.5;
                totalHakjum += subjectHakjum[i];
            } else if (subjectRank[i].equals("D0")) {
                totalScore += subjectHakjum[i] * 1.0;
                totalHakjum += subjectHakjum[i];
            } else if (subjectRank[i].equals("F")) {
                totalScore += subjectHakjum[i] * 0.0;
                totalHakjum += subjectHakjum[i];
            }
        }

        System.out.println(totalScore / totalHakjum);
    }
}
