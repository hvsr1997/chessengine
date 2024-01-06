package com.chess.engine.board;

import com.chess.engine.piece.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();

    private static Map<Integer,EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer,EmptyTile> emptyTileMap = new HashMap<>();
        for(int i=0;i<64;i++){
            emptyTileMap.put(i,new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES.get(tileCoordinate);
    }
    Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean ifTileOccupied();
    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {
        EmptyTile(final int coordinate){
            super(coordinate);
        }

        @Override
        public boolean ifTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

    }

    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile;
        OccupiedTile(final int tileCoordinate, Piece piece) {
            super(tileCoordinate);
            this.pieceOnTile = piece;
        }

        @Override
        public boolean ifTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }

    }
}
