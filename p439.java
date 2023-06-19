/*
 * A friend of you is doing research on the Traveling Knight Problem (TKP) where you are to find the
shortest closed tour of knight moves that visits each square of a given set of n squares on a chessboard
exactly once. He thinks that the most difficult part of the problem is determining the smallest number
of knight moves between two given squares and that, once you have accomplished this, finding the tour
would be easy.
Of course you know that it is vice versa. So you offer him to write a program that solves the
”difficult” part.
Your job is to write a program that takes two squares a and b as input and then determines the
number of knight moves on a shortest route from a to b.
Input
The input file will contain one or more test cases. Each test case consists of one line containing two
squares separated by one space. A square is a string consisting of a letter (a..h) representing the column
and a digit (1..8) representing the row on the chessboard.
Output
For each test case, print one line saying ‘To get from xx to yy takes n knight moves.’.
Sample Input:
e2 e4
a1 b2
b2 c3
a1 h8
a1 h7
h8 a1
b1 c3
f6 f6
Sample Output:
To get from e2 to e4 takes 2 knight moves.
To get from a1 to b2 takes 4 knight moves.
To get from b2 to c3 takes 2 knight moves.
To get from a1 to h8 takes 6 knight moves.
To get from a1 to h7 takes 5 knight moves.
To get from h8 to a1 takes 6 knight moves.
To get from b1 to c3 takes 1 knight moves.
To get from f6 to f6 takes 0 knight moves
 */

public class p439 {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            int x1 = a.charAt(0) - 'a'; // convert char to int
            int y1 = a.charAt(1) - '1'; // convert char to int
            int x2 = b.charAt(0) - 'a'; // convert char to int
            int y2 = b.charAt(1) - '1'; // convert char to int
            int[][] board = new int[8][8]; // create a chessboard
            int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 }; // 8 possible moves
            int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 }; // 8 possible moves
            java.util.Queue<Integer> qx = new java.util.LinkedList<>(); // create a queue
            java.util.Queue<Integer> qy = new java.util.LinkedList<>(); // create a queue
            qx.add(x1); // add x1 to queue
            qy.add(y1); // add y1 to queue
            board[x1][y1] = 1;
            while (!qx.isEmpty()) { // while queue is not empty
                int x = qx.poll(); // remove x from queue
                int y = qy.poll(); // remove y from queue
                if (x == x2 && y == y2) { // if x and y are equal to x2 and y2
                    System.out.println(
                            "To get from " + a + " to " + b + " takes " + (board[x][y] - 1) + " knight moves.");
                    break;
                }
                for (int i = 0; i < 8; i++) { // for loop to check all 8 possible moves
                    int nx = x + dx[i]; // new x
                    int ny = y + dy[i]; // new y
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && board[nx][ny] == 0) { // if new x and new y are valid
                        qx.add(nx); // add new x to queue
                        qy.add(ny); // add new y to queue
                        board[nx][ny] = board[x][y] + 1; // update board
                    }
                }
            }
        }
        sc.close();
    }

}
