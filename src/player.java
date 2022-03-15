import java.util.Scanner;

public class player {
    public static void main(String[] args){
        char[][] gameBoard = new char[3][3];
        //  printBoard(gameBoard);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String gamePlay = scanner.nextLine();
        char[] result = gamePlay.toCharArray();
        int ticTac = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = result[ticTac];
                ticTac++;
            }
        }
        printBoard(gameBoard);
        System.out.println(getState(gameBoard));
    }

    private static void printBoard(char[][] gameBoard) {
        System.out.println("---------");
        System.out.println("|" + " " + gameBoard[0][0] + " " + gameBoard[0][1] + " " + gameBoard[0][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[1][0] + " " + gameBoard[1][1] + " " + gameBoard[1][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[2][0] + " " + gameBoard[2][1] + " " + gameBoard[2][2] + " " + "|");
        System.out.println("---------");
    }


    private static String getState(char[][] gameBoard) {
        boolean xWins = isTheWinner(gameBoard, 'X');
        boolean oWins = isTheWinner(gameBoard, 'O');

        if (xWins && oWins || isImpossible(gameBoard)) {
            return "Impossible";
        } else if (xWins) {
            return "X wins";
        } else if (oWins) {
            return "O wins";
        } else if (!isGameFinished(gameBoard)) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    private static boolean isGameFinished(char[][] gameBoard) {
        for (char[] chars : gameBoard) {
            for (char aChar : chars) {
                if (aChar == '_') {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isTheWinner(char[][] gameBoard, char symbol) {
        return (gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
                (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
                (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
                (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);


    }

    private static boolean isImpossible(char[][] gameBoard) {
        int xCount = 0;
        int oCount = 0;

        for (char[] chars : gameBoard) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    xCount++;
                }
                if (aChar == 'O') {
                    oCount++;
                }
            }
        }

        return Math.abs(xCount - oCount) > 1;
    }
}
