import java.util.Scanner;

public class fight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] array = new char[3][3];
        boolean xWin = false;
        boolean oWin = false;
        boolean isDraw = false;
        boolean isEven = false;

        printGrid(array);

        while (!xWin && !oWin && !isDraw) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();

            if (!input.matches("^\\s*\\d\\s+\\d\\s*$")) {
                System.out.println("You should enter numbers!");
            } else {
                String[] arrOfStr = input.split(" ");

                int coor1 = Integer.parseInt(arrOfStr[0]);
                int coor2 = Integer.parseInt(arrOfStr[1]);

                boolean isValidMove = true;

                if (coor1 > 3 || coor2 > 3) {
                    isValidMove = false;
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (array[coor1 - 1][coor2 - 1] != 0) {
                    isValidMove = false;
                    System.out.println("This cell is occupied! Choose another one!");
                }

                if (isValidMove) {
                    if (!isEven) {
                        array[coor1 - 1][coor2 - 1] = 'X';
                        isEven = true;
                    } else {
                        array[coor1 - 1][coor2 - 1] = 'O';
                        isEven = false;
                    }

                    printGrid(array);

                    if (isWinner('X', array)) {
                        xWin = true;
                        System.out.println("X wins");
                    } else if (isWinner('O', array)) {
                        oWin = true;
                        System.out.println("O wins");
                    } else if (isDraw(array)) {
                        isDraw = true;
                        System.out.println("Draw");
                    }
                }
            }
        }
    }


    public static void printGrid(char[][] array) {
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");

            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(array[i][j] + " ");
                }
            }

            System.out.println("|");
        }

        System.out.println("---------");
    }

    public static boolean isWinner(char player, char[][] array) {
        return isHorizontalWin(player, array) ||
                isVerticalWin(player, array) ||
                isDiagonalWin(player, array);
    }

    public static boolean isHorizontalWin(char player, char[][] array) {
        return array[0][0] + array[0][1] + array[0][2] == player * 3 ||
                array[1][0] + array[1][1] + array[1][2] == player * 3 ||
                array[2][0] + array[2][1] + array[2][2] == player * 3;
    }

    public static boolean isVerticalWin(char player, char[][] array) {
        return array[0][0] + array[1][0] + array[2][0] == player * 3 ||
                array[0][1] + array[1][1] + array[2][1] == player * 3 ||
                array[0][2] + array[1][2] + array[2][2] == player * 3;
    }

    public static boolean isDiagonalWin(char player, char[][] array) {
        return array[0][0] + array[1][1] + array[2][2] == player * 3 ||
                array[2][0] + array[1][1] + array[0][2] == player * 3;
    }

    public static boolean isDraw(char[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
