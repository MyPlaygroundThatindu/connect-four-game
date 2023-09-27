package lk.ijse.dep.service;

public class BoardImpl implements Board{
    private final Piece[][] pieces;
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                pieces[i][j] = Piece.EMPTY;
            }

        }
    }

    @Override
    public BoardUI getBoardUI() {
        return this.boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if(pieces[col][i] == Piece.EMPTY) return i;
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        if(findNextAvailableSpot(col) != -1){
            //Empty space available
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            if(!isLegalMove(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void updateMove(int col, Piece move) {
        int row = findNextAvailableSpot(col);
        pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {

        if(!existLegalMoves()) return new Winner(Piece.EMPTY);

        for (int i = 0; i < NUM_OF_COLS; i++) {
            if((pieces[i][0] == Piece.GREEN ) && (pieces[i][1] == Piece.GREEN) && (pieces[i][2] == Piece.GREEN) && (pieces[i][3] == Piece.GREEN)){
                return new Winner(pieces[i][3], i, 0, i, 3);
            } else if ((pieces[i][1] == Piece.GREEN ) && (pieces[i][2] == Piece.GREEN) && (pieces[i][3] == Piece.GREEN) && (pieces[i][4] == Piece.GREEN)) {
                return new Winner(pieces[i][4], i, 1, i, 4);
            } else if((pieces[i][0] == Piece.BLUE ) && (pieces[i][1] == Piece.BLUE) && (pieces[i][2] == Piece.BLUE) && (pieces[i][3] == Piece.BLUE)){
                return new Winner(pieces[i][3], i, 0, i, 3);
            } else if ((pieces[i][1] == Piece.BLUE ) && (pieces[i][2] == Piece.BLUE) && (pieces[i][3] == Piece.BLUE) && (pieces[i][4] == Piece.BLUE)) {
                return new Winner(pieces[i][4], i, 1, i, 4);
            }
        }

        for (int j = 0; j < NUM_OF_ROWS; j++) {
            if((pieces[0][j] == Piece.GREEN ) && (pieces[1][j] == Piece.GREEN) && (pieces[2][j] == Piece.GREEN) && (pieces[3][j] == Piece.GREEN)){
                return new Winner(pieces[3][j], 0, j, 3, j);
            } else if ((pieces[1][j] == Piece.GREEN ) && (pieces[2][j] == Piece.GREEN) && (pieces[3][j] == Piece.GREEN) && (pieces[4][j] == Piece.GREEN)) {
                return new Winner(pieces[4][j], 1, j, 4, j);
            } else if ((pieces[2][j] == Piece.GREEN ) && (pieces[3][j] == Piece.GREEN) && (pieces[4][j] == Piece.GREEN) && (pieces[5][j] == Piece.GREEN)) {
                return new Winner(pieces[5][j], 2, j, 5, j);
            } else if((pieces[0][j] == Piece.BLUE ) && (pieces[1][j] == Piece.BLUE) && (pieces[2][j] == Piece.BLUE) && (pieces[3][j] == Piece.BLUE)){
                return new Winner(pieces[3][j], 0, j, 3, j);
            } else if ((pieces[1][j] == Piece.BLUE ) && (pieces[2][j] == Piece.BLUE) && (pieces[3][j] == Piece.BLUE) && (pieces[4][j] == Piece.BLUE)) {
                return new Winner(pieces[4][j], 1, j, 4, j);
            } else if ((pieces[2][j] == Piece.BLUE ) && (pieces[3][j] == Piece.BLUE) && (pieces[4][j] == Piece.BLUE) && (pieces[5][j] == Piece.BLUE)) {
                return new Winner(pieces[5][j], 2, j, 5, j);
            }
        }

        return new Winner(Piece.EMPTY);
    }
}
