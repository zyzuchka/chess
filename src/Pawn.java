public class Pawn extends ChessPiece{
    private String letter = "P";
    private String color;

    public Pawn(String inColor) { //Constructor, although how does it work without coordinates???
        color = inColor;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int deltaX = toLine - line; // Calculates difference in X (should be always +1 or +2 for pawn, so no abs)
        int deltaY = Math.abs(toColumn - column); // Calculates difference in Y (should be always 1 or 2 for pawn)


        if (!isValidMove(line, column) || !isValidMove(toLine, toColumn) || (deltaX == 0 && deltaY == 0)) {//Checks if starting and target positions are within board
            return false;
        }

        if(this.getColor() == (chessBoard.board[toLine][toColumn]).getColor()){ //checking if color of chess piece on target cell matches ours, if yes then move is impossible
            return false;
        }

        if (deltaY == 0) { // Checks if pawn is not moving sideways
            if (deltaX == 1) { //Pawn can always move one cell forward
                return true;
            }
            else if (deltaX == 2 && line == 1) { //Pawn can only move 2 cells forward on first move (i.e on its original line)
                return true;
            }
        }
        return false;
    }


    private boolean isValidMove(int line, int column) {
        if(line >= 0 && line < 8 && column >= 0 && column < 8){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return letter;
    }

}
