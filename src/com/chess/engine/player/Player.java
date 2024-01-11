package com.chess.engine.player;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.piece.King;
import com.chess.engine.piece.Piece;

import java.util.Collection;

public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;

    protected Player(final Board board,
                     final Collection<Move> legalMoves,
                     final Collection<Move> opponentMoves) {
        this.board = board;
        this.playerKing = establishKing();
        this.legalMoves = legalMoves;

    }

    private King establishKing() {
        for(final Piece piece : getMyActivePieces()){
            if(piece.getPieceType().isKing()) {
                return (King) piece;
            }
        }
        throw new RuntimeException("not a valid board");
    }
    public boolean isMoveLegal(Move move) {
        return this.legalMoves.contains(move);
    }
    public boolean isInCheck() {
        return false;
    }
    public boolean isInCheckMate() {
        return false;
    }
    public boolean isInStaleMate() {
        return false;
    }
    public boolean isCastled() {
        return false;
    }
    public MoveTransition makeMove(final Move move) {
        return null;
    }

    public abstract Collection<Piece> getMyActivePieces();
    public abstract Alliance getAlliance();
    public abstract Player getOpponent();
}
