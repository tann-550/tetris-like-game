public class Board {
    public final int column = 10;
    public final int row = 20;
    public Block[][] grid;

    public Board() {
        grid = new Block[row][];

        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                grid[i][j] = new Block();
            }
        }
    }
    public Block[][] getGrid() { return this.grid; }

    public boolean valid(Tetromino t, int x, int y) {
        int[][] shape = t.getShape();

        for(int i = 0; i < shape.length; i++) {
            for(int j = 0; i < shape.length; j++) {
                if(shape[i][j] != 0) {
                    int boardX = x + i;
                    int boardY = y + j;

                    if(boardX < 0 || boardX >= 10) {
                        return false;
                    }
                    if(boardY >= 20) {
                        return false;
                    }
                    if(boardX >= 0 && grid[boardX][boardY].hasPiece()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}