package be.switchfully.gameoflife.backend.gol;

public class Cell {
    private boolean isPopulated;

    public boolean isPopulated() {
        return isPopulated;
    }

    public void setPopulated(boolean populated) {
        isPopulated = populated;
    }

    public Cell(boolean isPopulated) {
        this.isPopulated = isPopulated;
    }
}
