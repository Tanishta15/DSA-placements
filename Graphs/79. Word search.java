class Solution {
public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word == null || word.length()== 0) {
        return false;
        }
    for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
    if (board[i][j] == word.charAt(0)) {//if first correct then only proceed
        if (dfs(board, i, j, word)) {
            return true;
        }
        }
        }
        }
        return false;
        }
public boolean dfs(char[][] board, int i, int j, String word) {
    if (i < 0 || i >= board.length || j < 0 || j >=board[0].length || board[i][j] != word.charAt(0)) {
        return false;
        }
        if (word.length() == 1) {
            return true;
            }
            char tmp = board[i][j];
            board[i][j] = '#';
            //go in all four directions to find 1 and return true i.e word can be formed there
            boolean res = dfs(board, i + 1, j, word.substring(1))|| dfs(board, i - 1, j, word.substring(1))|| dfs(board, i, j + 1, word.substring(1))|| dfs(board, i, j - 1, word.substring(1));
            board[i][j] = tmp;
            return res;
}
}