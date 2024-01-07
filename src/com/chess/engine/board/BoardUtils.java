package com.chess.engine.board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = null;
    public static final boolean [] SECOND_COLUMN = null;
    public static final  boolean [] SEVENTH_COLUMN = null;
    public static final boolean [] EIGHTH_COLUMN = null;

    private BoardUtils(){
        throw new RuntimeException("Cant instantiate this");
    }
    public static boolean isValidTileCoordinate(int candidateDestinationPosition) {
        return candidateDestinationPosition >= 0 && candidateDestinationPosition < 64;
    }
}
