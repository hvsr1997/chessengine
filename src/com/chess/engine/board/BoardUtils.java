package com.chess.engine.board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = inItColumn(0);
    public static final boolean [] SECOND_COLUMN = inItColumn(1);;
    public static final  boolean [] SEVENTH_COLUMN = inItColumn(6);;
    public static final boolean [] EIGHTH_COLUMN = inItColumn(7);;

    public static final boolean [] SECOND_ROW = initRow(8);;

    public static final boolean [] SEVENTH_ROW = initRow(48);

    private static boolean[] initRow(int rowNumber) {
        final boolean[] row = new boolean[NUM_TILES];
        do {
            row[rowNumber] = true;
            rowNumber ++;
        }while(rowNumber % NUM_TILES_PER_ROW !=0);
        return row;
    }

    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;


    private BoardUtils(){
        throw new RuntimeException("Cant instantiate this");
    }
    public static boolean isValidTileCoordinate(final int candidateDestinationPosition) {
        return candidateDestinationPosition >= 0 && candidateDestinationPosition < NUM_TILES;
    }

    private static boolean[] inItColumn(int columnNumber) {
        final boolean[] column = new boolean[NUM_TILES];
        do {
            column[columnNumber] = true;
            columnNumber +=NUM_TILES_PER_ROW;
        }while(columnNumber<NUM_TILES);
        return column;

    }

}
