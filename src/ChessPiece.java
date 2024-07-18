public abstract class ChessPiece {
    private String color;
    public boolean check;

    public ChessPiece(String color) {

    }

    protected ChessPiece() {
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

}