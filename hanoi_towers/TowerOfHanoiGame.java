package hanoi_towers;

import java.util.Scanner;

public class TowerOfHanoiGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Save save = new Save();
        int moves = 0;

        System.out.println("Добро пожаловать в игру Ханойские башни!");
        System.out.println("Выберите режим игры (1 - ручной режим, 2 - автоматический режим)");
        int gameMod = scanner.nextInt();
        switch (gameMod) {
            case 1:
                System.out.print("Вы выбрали ручной режим.\nВведите количество колец (от 3 до 8): ");
                int numDisks = scanner.nextInt();

                if (numDisks < 3 || numDisks > 8) {
                    System.out.println("Некорректное количество колец. Игра завершена.");
                    return;
                }

                int[][] gameBoard = initializeGameBoard(numDisks);
                displayGameBoard(gameBoard);

                while (true) {
                    System.out.print("Введите исходную и целевую башни (например, '1 3'): ");
                    int fromPeg = scanner.nextInt();
                    int toPeg = scanner.nextInt();

                    if (isValidMove(gameBoard, fromPeg, toPeg)) {
                        moveDisk(gameBoard, fromPeg, toPeg);
                        moves++;
                        displayGameBoard(gameBoard);

                        if (isGameComplete(gameBoard, numDisks)) {
                            System.out.println("Поздравляем! Вы выиграли!");
                            System.out.println("Количество ходов: " + moves);
                            break;
                        }
                    } else {
                        System.out.println("Невозможно выполнить ход. Попробуйте снова.");
                    }
                }

                scanner.close();
                break;
            case 2:
                System.out.println("Вы выбрали автоматический режим.\nВведите количество колец (от 3 до 8): ");
                int numDisks1 = scanner.nextInt();

                if (numDisks1 < 3 || numDisks1 > 8) {
                    System.out.println("Некорректное количество колец. Игра завершена.");
                    return;
                }
                int[][] gameBoard1 = initializeGameBoard(numDisks1);
                displayGameBoard(gameBoard1);
                moves = (int) Math.pow(2, numDisks1) - 1;

                solveTowerOfHanoi(numDisks1, 1, 3, 2, gameBoard1);

                System.out.println("Игра завершена. Поздравляем!");
                System.out.println("Количество ходов: " + moves);
                break;
            default:
                System.out.println("Некорректный выбор режима игры.");
        }
    }

    public static int[][] initializeGameBoard(int numDisks) {
        int[][] gameBoard = new int[numDisks][3];
        for (int i = 0; i < numDisks; i++) {
            gameBoard[i][0] = i + 1;
        }
        return gameBoard;
    }

    public static void displayGameBoard(int[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print(gameBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isValidMove(int[][] gameBoard, int fromPeg, int toPeg) {
        fromPeg--;
        toPeg--;

        if (fromPeg < 0 || fromPeg >= 3 || toPeg < 0 || toPeg >= 3) {
            return false;
        }

        int fromDisk = findTopDisk(gameBoard, fromPeg);
        int toDisk = findTopDisk(gameBoard, toPeg);

        if (toDisk == 0 || fromDisk < toDisk) {
            return true;
        }

        return false;
    }

    public static void moveDisk(int[][] gameBoard, int fromPeg, int toPeg) {
        fromPeg--;
        toPeg--;

        int fromDisk = findTopDisk(gameBoard, fromPeg);

        for (int i = gameBoard.length - 1; i >= 0; i--) {
            if (gameBoard[i][toPeg] == 0) {
                gameBoard[i][toPeg] = fromDisk;
                gameBoard[findDiskIndex(gameBoard, fromPeg, fromDisk)][fromPeg] = 0;
                break;
            }
        }
    }

    public static int findTopDisk(int[][] gameBoard, int peg) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][peg] != 0) {
                return gameBoard[i][peg];
            }
        }
        return 0;
    }

    public static int findDiskIndex(int[][] gameBoard, int peg, int disk) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][peg] == disk) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isGameComplete(int[][] gameBoard, int numDisks) {
        for (int i = 0; i < numDisks; i++) {
            if (gameBoard[i][2] != i + 1) {
                return false;
            }
        }
        return true;
    }
    public static void solveTowerOfHanoi(int n, int source, int target, int auxiliary, int[][] gameBoard) {
        if (n == 1) {
            moveDisk(gameBoard, source, target);
            displayGameBoard(gameBoard);
        } else {
            solveTowerOfHanoi(n - 1, source, auxiliary, target, gameBoard);
            moveDisk(gameBoard, source, target);
            displayGameBoard(gameBoard);
            solveTowerOfHanoi(n - 1, auxiliary, target, source, gameBoard);
        }
    }
}
