public class Cell {
    CellStatus cellStatus;

    public Cell() {
        this.cellStatus = CellStatus.EMPTY;
    }

    public void insertX() {
        this.cellStatus = CellStatus.X;
    }

    public void insertO() {
        this.cellStatus = CellStatus.O;
    }
}
