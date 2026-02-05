import java.io.*;
import java.util.*;

public class P12100 {
    public static int maxScore = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] table = new int[size][size];
        for(int x = 0; x < size; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int y = 0; y < size; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(table, size, 0);

        System.out.println(maxScore);
    }

    public static void simulation(int[][] table, int size, int time) {
        if(time == 5) {
            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    maxScore = Math.max(maxScore, table[x][y]);
                }
            }

            return;
        }


        for(int i = 1; i <= 4; i++) {
            int[][] dummyTable = new int[size][size];

            for(int x = 0; x < size; x++) {
                dummyTable[x] = table[x].clone();
            }

            move(dummyTable, size, i);

            simulation(dummyTable, size, time + 1);
        }
    }

    public static void move(int[][] table, int size, int direction) {
        //아래
        if(direction == 1) {
            for(int y = 0; y < size; y++) {
                Queue<Integer> q = new LinkedList<>();
                Queue<Integer> result = new LinkedList<>();

                for(int x = size - 1; x >= 0; x--) {
                    if(table[x][y] != 0) {
                        q.add(table[x][y]);
                    }
                }

                while(!q.isEmpty()) {
                    int current = q.poll();
                    if(!q.isEmpty()) {
                        if(current == q.peek()) {
                            current *= 2;
                            q.poll();
                            result.add(current);
                        } else {
                            result.add(current);
                        }
                    } else {
                        result.add(current);
                    }
                }

                int index = size - 1;
                while(!result.isEmpty()) {
                    table[index--][y] = result.poll();
                }

                while(index >= 0) {
                    table[index--][y] = 0;
                }
            }
        }


        //위
        if(direction == 2) {
            for(int y = 0; y < size; y++) {
                Queue<Integer> q = new LinkedList<>();
                Queue<Integer> result = new LinkedList<>();

                for(int x = 0; x < size; x++) {
                    if(table[x][y] != 0) {
                        q.add(table[x][y]);
                    }
                }

                while(!q.isEmpty()) {
                    int current = q.poll();
                    if(!q.isEmpty()) {
                        if(current == q.peek()) {
                            current *= 2;
                            q.poll();
                            result.add(current);
                        } else {
                            result.add(current);
                        }
                    } else {
                        result.add(current);
                    }
                }

                int index = 0;
                while(!result.isEmpty()) {
                    table[index++][y] = result.poll();
                }

                while(index < size) {
                    table[index++][y] = 0;
                }
            }
        }

        //왼쪽
        if(direction == 3) {
            for(int x = 0; x < size; x++) {
                Queue<Integer> q = new LinkedList<>();
                Queue<Integer> result = new LinkedList<>();

                for(int y = 0; y < size; y++) {
                    if(table[x][y] != 0) {
                        q.add(table[x][y]);
                    }
                }

                while(!q.isEmpty()) {
                    int current = q.poll();
                    if(!q.isEmpty()) {
                        if(current == q.peek()) {
                            current *= 2;
                            q.poll();
                            result.add(current);
                        } else {
                            result.add(current);
                        }
                    } else {
                        result.add(current);
                    }
                }

                int index = 0;
                while(!result.isEmpty()) {
                    table[x][index++] = result.poll();
                }

                while(index < size) {
                    table[x][index++] = 0;
                }
            }
        }


        //오른쪽
        if(direction == 4) {
            for(int x = 0; x < size; x++) {
                Queue<Integer> q = new LinkedList<>();
                Queue<Integer> result = new LinkedList<>();

                for(int y = size - 1; y >= 0; y--) {
                    if(table[x][y] != 0) {
                        q.add(table[x][y]);
                    }
                }

                while(!q.isEmpty()) {
                    int current = q.poll();
                    if(!q.isEmpty()) {
                        if(current == q.peek()) {
                            current *= 2;
                            q.poll();
                            result.add(current);
                        } else {
                            result.add(current);
                        }
                    } else {
                        result.add(current);
                    }
                }

                int index = size - 1;
                while(!result.isEmpty()) {
                    table[x][index--] = result.poll();
                }

                while(index >= 0) {
                    table[x][index--] = 0;
                }
            }
        }
    }
}
