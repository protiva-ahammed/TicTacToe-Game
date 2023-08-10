import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static boolean fin;

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {

            printBoard(board);
            System.out.println("Player  " + player + " enter: ");

            //to enter row col for the players

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            //check is the row is empty or not otherwise invalid

            if (board[row][col] == ' ') {
                //place the element
                board[row][col] = player;//player is going to be X or O

                gameOver = haveWin(board, player);

                if (gameOver) {
                    System.out.println(" Player " + player + " is the Winner!!");
                }
                //switching player
                else {
//                   if(player == 'X'){
//                       player='O';
//                   }
//                   else {
//
//                       player = 'X';
//
//                   }

                    player = (player == 'X') ? 'O' : 'X';


                }

            } else {
                System.out.println("Invalid move. Try again ..");
            }


        }

        printBoard(board);
        if(checkDraw(board))
            System.out.println("Game is Draw!! Want to play again?");

    }

    public static boolean haveWin(char[][] board, char player) {

        //check the rows

        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        //check for col

        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        //diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;

        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;

        }

        return false;


    }

    public static void printBoard(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }

            System.out.println();

        }

        System.out.println();


    }


    public static boolean checkDraw(char [][] board){
        for(int row = 0; row< board.length; row++){
            for(int col = 0; col< board[row].length;col++)
            {
                if(board[row][col]!=' '){
                    fin=true;
                }

                else
                    fin=false;
            }
        }

        return fin;
    }

}