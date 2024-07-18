public class Horse extends ChessPiece{
    private String letter = "H";
    private String color;

    public Horse(String inColor) {
        color = inColor;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int deltaX = Math.abs(toLine - line); //Calculates difference in X between target and starting cell (should be 1 or 2 for Horse, see pictures)
        int deltaY = Math.abs(toColumn - column); //Calculates difference in Y between target and starting cell (should be 1 or 2 for Horse, see pictures)

        if (!isValidMove(line, column) || !isValidMove(toLine, toColumn) || (deltaX == 0 && deltaY == 0)) { //Checks if starting or target position are within 0 to 8 and whether they are the same
            return false;
        }

        if(chessBoard.board[toLine][toColumn] != null){
            return false;
        }

        if(this.getColor() == (chessBoard.board[toLine][toColumn]).getColor()){ //checking if color of chess piece on target cell matches ours, if yes then move is impossible
            return false;
        }

        if((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)){ //Checks differences according to the rules of chess
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isValidMove(int line, int column) { //checks whether starting or target cell is on board
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
