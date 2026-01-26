import java.io.*;
import java.util.*;

public class P10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        long pow = Long.parseLong(st.nextToken());

        int[][] matrix = new int[size][size];

        for(int x = 0; x < size; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                matrix[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] resultMatrix = power(matrix, pow, size);

        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                sb.append(resultMatrix[x][y] % 1000).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[][] power(int[][] matrix, long pow, int size) {
        if(pow == 1) {
            return matrix;
        }

        int[][] temp = power(matrix, pow / 2, size);

        if(pow % 2 == 0) {
            return matrixMultiplication(temp, temp, size);
        } else {
            return matrixMultiplication(matrixMultiplication(temp, temp, size), matrix, size);
        }
    }


    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2, int size) {
        int[][] resultMatrix = new int[size][size];

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                for(int z = 0; z < size; z++) {
                    resultMatrix[x][y] += matrix1[x][z] * matrix2[z][y] % 1000;
                }
            }
        }

        return resultMatrix;
    }
}
