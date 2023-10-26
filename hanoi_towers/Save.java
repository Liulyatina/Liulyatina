package hanoi_towers;

import java.util.Stack;

class Save {
    private Stack<int[][]> gameStates = new Stack<>();

    public void saveState(int[][] gameBoard) {
        gameStates.push(copyGameBoard(gameBoard));
    }

    public boolean hasPreviousState() {
        return !gameStates.isEmpty();
    }

    public int[][] loadPreviousState() {
        if (!gameStates.isEmpty()) {
            return gameStates.pop();
        }
        return null;
    }
    public static int[][] copyGameBoard(int[][] gameBoard) {
        int[][] copy = new int[gameBoard.length][3];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = gameBoard[i][j];
            }
        }
        return copy;
    }
}
