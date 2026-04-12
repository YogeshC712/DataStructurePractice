package org.yhc.programming.pattern.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'B', 'L', 'C', 'H'},
                {'D', 'E', 'L', 'T'},
                {'D', 'A', 'K', 'A'}
        };
        String word = "BLED";

        System.out.println("The word is present on board? " + wordSearch(board, word));
    }

    private static boolean wordSearch(char[][] board, String word){
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(board[r][c] == word.charAt(0)){
                    if(dfs(board, word, r, c, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int r, int c, int index){
        //we have found the target word in our grid
        if(index == word.length()){
            return true;
        }

        //restrict the search in bounds
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length
                || board[r][c] != word.charAt(index)){
            return false;
        }

        //To keep track of visited cells
        char temp = board[r][c];
        board[r][c] = '#';

        //recursive calls to explore each of its 4 neighbors (in the N, W, S, E) directions
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);

        //"frees" up the cell to be used by another path in the future,
        board[r][c] = temp;

        return found;
    }
}
