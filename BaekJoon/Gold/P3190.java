import java.io.*;
import java.util.*;

public class P3190 {
    public static class order implements Comparable<order> {
        int time;
        char direction;

        order(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }

        @Override
        public int compareTo(order o) {
            return Integer.compare(this.time, o.time);
        }
    }

    //3은 벽
    //2는 사과
    //1은 몸통

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boardSize = Integer.parseInt(br.readLine());
        int[][] board = new int[boardSize + 2][boardSize + 2];
        for(int y = 0; y <= boardSize + 1; y++) {
            board[0][y] = 3;
            board[boardSize + 1][y] = 3;
        }

        for(int x = 0; x <= boardSize + 1; x++) {
            board[x][0] = 3;
            board[x][boardSize + 1] = 3;
        }

        int appleNumber = Integer.parseInt(br.readLine());
        for(int i = 0; i < appleNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int appleXPosition = Integer.parseInt(st.nextToken());
            int appleYPosition = Integer.parseInt(st.nextToken());

            board[appleXPosition][appleYPosition] = 2;
        }

        int orderNumber = Integer.parseInt(br.readLine());
        Queue<order> q = new LinkedList<>();
        for(int i = 0; i < orderNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            q.add(new order(time, direction));
        }

        int length = 1;
        Deque<int[]> body = new LinkedList<>();
        body.add(new int[]{1, 1});
        int direction = 2;
        int time = 0;
        while(true) {
            if(direction == 1) {
                time++;

                int nextX = body.peekFirst()[0] - 1;
                int nextY = body.peekFirst()[1];

                if(board[nextX][nextY] == 3 || board[nextX][nextY] == 1) {
                    System.out.println(time);
                    return;
                }

                if(board[nextX][nextY] == 2) {
                    length++;
                }

                body.addFirst(new int[]{nextX, nextY});
                board[nextX][nextY] = 1;

                while(body.size() > length) {
                    int[] removePosition = body.pollLast();
                    board[removePosition[0]][removePosition[1]] = 0;
                }

                if(!q.isEmpty()) {
                    if(time == q.peek().time) {
                        char nextDirection = q.poll().direction;

                        if(nextDirection == 'D') {
                            direction = 2;
                        } else if (nextDirection == 'L') {
                            direction = 4;
                        }
                    }
                }
            }

            if(direction == 2) {
                time++;

                int nextX = body.peekFirst()[0];
                int nextY = body.peekFirst()[1] + 1;

                if(board[nextX][nextY] == 3 || board[nextX][nextY] == 1) {
                    System.out.println(time);
                    return;
                }

                if(board[nextX][nextY] == 2) {
                    length++;
                }

                body.addFirst(new int[]{nextX, nextY});
                board[nextX][nextY] = 1;

                while(body.size() > length) {
                    int[] removePosition = body.pollLast();
                    board[removePosition[0]][removePosition[1]] = 0;
                }

                if(!q.isEmpty()) {
                    if(time == q.peek().time) {
                        char nextDirection = q.poll().direction;

                        if(nextDirection == 'D') {
                            direction = 3;
                        } else if (nextDirection == 'L') {
                            direction = 1;
                        }
                    }
                }
            }

            if(direction == 3) {
                time++;

                int nextX = body.peekFirst()[0] + 1;
                int nextY = body.peekFirst()[1];

                if(board[nextX][nextY] == 3 || board[nextX][nextY] == 1) {
                    System.out.println(time);
                    return;
                }

                if(board[nextX][nextY] == 2) {
                    length++;
                }

                body.addFirst(new int[]{nextX, nextY});
                board[nextX][nextY] = 1;

                while(body.size() > length) {
                    int[] removePosition = body.pollLast();
                    board[removePosition[0]][removePosition[1]] = 0;
                }

                if(!q.isEmpty()) {
                    if(time == q.peek().time) {
                        char nextDirection = q.poll().direction;

                        if(nextDirection == 'D') {
                            direction = 4;
                        } else if (nextDirection == 'L') {
                            direction = 2;
                        }
                    }
                }
            }

            if(direction == 4) {
                time++;

                int nextX = body.peekFirst()[0];
                int nextY = body.peekFirst()[1] - 1;

                if(board[nextX][nextY] == 3 || board[nextX][nextY] == 1) {
                    System.out.println(time);
                    return;
                }

                if(board[nextX][nextY] == 2) {
                    length++;
                }

                body.addFirst(new int[]{nextX, nextY});
                board[nextX][nextY] = 1;

                while(body.size() > length) {
                    int[] removePosition = body.pollLast();
                    board[removePosition[0]][removePosition[1]] = 0;
                }

                if(!q.isEmpty()) {
                    if(time == q.peek().time) {
                        char nextDirection = q.poll().direction;

                        if(nextDirection == 'D') {
                            direction = 1;
                        } else if (nextDirection == 'L') {
                            direction = 3;
                        }
                    }
                }
            }
        }
    }
}
