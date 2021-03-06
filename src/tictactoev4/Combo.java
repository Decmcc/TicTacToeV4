package tictactoev4;

public class Combo {
    public  Tile[] tiles;
    public Combo(Tile... tiles) {
        this.tiles = tiles;
    }
    public boolean isComplete() {
        if (tiles[0].getValue().isEmpty()) {
            return false;
        }

        return tiles[0].getValue().equals(tiles[1].getValue())
                && tiles[0].getValue().equals(tiles[2].getValue());

    }
}