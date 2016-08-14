/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
A partially filled sudoku which is valid.
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated. 
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if((board == null)||(board.length<9)||(board[0].length<9))
            return false;
        for(int i=0;i<9;i++){
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> column = new HashSet<Character>();
            for(int j=0;j<9;j++){
                if(board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !column.add(board[j][i]))
                    return false;
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                HashSet<Character> box = new HashSet<Character>();
                for(int x =i;x<i+3;x++){
                    for(int y =j;y<j+3;y++){
                        if(board[x][y] != '.' && !box.add(board[x][y]))
                             return false;
                    }
                }
            }
        }
        return true;
    }
}
