public class Bishop extends ChessPiece {
    private String letter = "B";
    private String color;

    public Bishop(String inColor) {
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

        if (!isValidMove(line, column) || !isValidMove(toLine, toColumn) || (deltaX == 0 && deltaY == 0)) { // Look for info in other classes :)
            return false;
        }

        if(chessBoard.board[toLine][toColumn] != null){
            return false;
        }

        if(this.getColor() == (chessBoard.board[toLine][toColumn]).getColor()){ //checking if color of chess piece on target cell matches ours, if yes then move is impossible
            return false;
        }

        if (deltaX == deltaY){ //Only diagonal move for bishop (without limits tho)
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isValidMove(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }

    @Override
    public String getSymbol() {
        return letter;
    }
}
