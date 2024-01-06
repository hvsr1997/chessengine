public abstract class ChessTIle {

    int tileCoordinate;
    ChessTIle(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean ifTileOccupied();
    public abstract Piece getPiece();

    public static final class EmptyChessTile extends ChessTIle{
        EmptyChessTile(int coordinate){
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

    public static final class OccupiedChessTile extends ChessTIle{

        Piece pieceOnTile;
        OccupiedChessTile(int tileCoordinate, Piece piece) {
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
