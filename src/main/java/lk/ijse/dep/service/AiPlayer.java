package lk.ijse.dep.service;

public class AiPlayer extends Player{
    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
        int randNum = 0;
        do{
            randNum = (int) Math.floor(Math.random() * (5 + 1));
        }while (!board.isLegalMove(randNum));

        board.updateMove(randNum, Piece.GREEN);
        board.getBoardUI().update(randNum, false);
        Winner winner = board.findWinner();

        if(winner.getWinningPiece() != Piece.EMPTY){
            board.getBoardUI().notifyWinner(winner);
        }else {
            if(board.existLegalMoves()){
//                board.getBoardUI().notifyWinner(winner);
            }
        }
    }
}
