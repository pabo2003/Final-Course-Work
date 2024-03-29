package lk.ijse.dep.service;

public class HumanPlayer extends Player {
    Winner winner;


    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col){
        if(board.isLegalMove(col)) {

            board.updateMove(col, Piece.BLUE);
            board.getBoardUI().update(col, true);

            if (board.findWinner().getWinningPiece().equals(Piece.EMPTY)) {
                if (!board.existLegalMoves()) {
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            } else {
                board.getBoardUI().notifyWinner(board.findWinner());
            }

        }
    }
}
