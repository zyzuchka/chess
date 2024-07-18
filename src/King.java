public class King extends ChessPiece {
    private String letter = "K";
    private String color;

    public King(String inColor) {
        color = inColor;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int deltaX = Math.abs(toLine - line); // Look for info in other classes :)
        int deltaY = Math.abs(toColumn - column); // Look for info in other classes :)

        if (!isValidMove(line, column) || !isValidMove(toLine, column) || (deltaX == 0 && deltaY == 0)) { // Look for info in other classes :)
            return false;
        }

        if(chessBoard.board[toLine][toColumn] != null){
            return false;
        }

        if(this.getColor() == (chessBoard.board[toLine][toColumn]).getColor()){ //checking if color of chess piece on target cell matches ours, if yes then move is impossible
            return false;
        }

        if (deltaX <= 1 && deltaY <= 1) { // King can move 1 cell to any direction
            return true;
        } else {
            return false;
        }
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (isValidMove(line, column) && isValidMove(column, column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }


    private boolean isValidMove(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }

    @Override
    public String getSymbol() {
        return letter;
    }
}
