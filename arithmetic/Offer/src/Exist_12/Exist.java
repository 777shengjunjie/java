package Exist_12;

public class Exist {

    public static void main(String[] args) {
        char[][] board={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word="ABCCED";
        boolean result=new Exist().exist(board,word);
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board,chars,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j,int k) {
        if (i>=board.length||i<0||j>= board[0].length||j<0||board[i][j]!=words[k]){
            return false;
        }
        if (k==words.length-1) return true;
        board[i][j]='\0';
        boolean res=dfs(board,words,i+1,j,k+1)||dfs(board,words,i-1,j,k+1)||
                dfs(board, words, i, j+1, k+1)||dfs(board, words, i, j-1, k+1);
        board[i][j]=words[k];

        return res;
    }
}
