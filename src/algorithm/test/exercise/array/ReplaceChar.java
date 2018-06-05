package algorithm.test.exercise.array;
/**
 * 如果字符O被X包围，则替换为X
 *
 * @author  j_cong
 * @date    2018/05/25
 * @version V1.0
 */
public class ReplaceChar {
    public static void main(String[] args) {
        char[][] c = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        solve(c);

    }

    public static void solve(char[][] board) {
        if (board == null ||board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        if (row < 3 || col < 3) {
            return;
        }
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
