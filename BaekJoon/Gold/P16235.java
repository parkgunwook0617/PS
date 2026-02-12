import java.io.*;
import java.util.*;

public class P16235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int treeNumber = Integer.parseInt(st.nextToken());
        int targetYear = Integer.parseInt(st.nextToken());

        int[][] table = new int[size][size];
        for(int x = 0; x < size; x++) {
            Arrays.fill(table[x], 5);
        }

        int[][] fertilizer = new int[size][size];

        for(int x = 0; x < size; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                fertilizer[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Integer>[][] trees = new ArrayDeque[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                trees[x][y] = new ArrayDeque<>();
            }
        }

        for(int i = 0; i < treeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int xPos = Integer.parseInt(st.nextToken()) - 1;
            int yPos = Integer.parseInt(st.nextToken()) - 1;
            int old = Integer.parseInt(st.nextToken());

            if(trees[xPos][yPos].isEmpty()) {
                trees[xPos][yPos].add(old);
            } else {
                if(trees[xPos][yPos].peek() >= old) {
                    trees[xPos][yPos].addFirst(old);
                } else {
                    trees[xPos][yPos].addLast(old);
                }
            }
        }

        List<Integer>[][] dead = new ArrayList[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                dead[x][y] = new ArrayList<>();
            }
        }

        while(targetYear != 0) {
            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    int currentSize = trees[x][y].size();

                    Deque<Integer> temp = new ArrayDeque<>();

                    for(int i = 0; i < currentSize; i++) {
                        int old = trees[x][y].pollFirst();

                        if(table[x][y] < old) {
                            dead[x][y].add(old);
                            continue;
                        }

                        table[x][y] -= old;
                        old += 1;
                        temp.addLast(old);
                    }

                    while(!temp.isEmpty()) {
                        trees[x][y].addLast(temp.pollFirst());
                    }
                }
            }

            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    if(dead[x][y].size() != 0) {
                        int currentSize = dead[x][y].size();

                        for(int i = 0; i < currentSize; i++) {
                            table[x][y] += dead[x][y].get(i) / 2;
                        }
                    }
                }
            }

            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    for(int old : trees[x][y]) {
                        if(old % 5 == 0) {
                            if(x - 1 >= 0 && y - 1 >= 0) {
                                trees[x - 1][y - 1].addFirst(1);
                            }

                            if(x - 1 >= 0) {
                                trees[x - 1][y].addFirst(1);
                            }

                            if(x - 1 >= 0 && y + 1 < size) {
                                trees[x - 1][y + 1].addFirst(1);
                            }

                            if(y - 1 >= 0) {
                                trees[x][y - 1].addFirst(1);
                            }

                            if(y + 1 < size) {
                                trees[x][y + 1].addFirst(1);
                            }

                            if(x + 1 < size && y - 1 >= 0) {
                                trees[x + 1][y - 1].addFirst(1);
                            }

                            if(x + 1 < size) {
                                trees[x + 1][y].addFirst(1);
                            }

                            if(x + 1 < size && y + 1 < size) {
                                trees[x + 1][y + 1].addFirst(1);
                            }
                        }
                    }
                }
            }

            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    if(fertilizer[x][y] != 0) {
                        table[x][y] += fertilizer[x][y];
                    }

                    dead[x][y].clear();
                }
            }

            targetYear--;
        }

        int alive = 0;
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                alive += trees[x][y].size();
            }
        }

        System.out.println(alive);
    }
}
