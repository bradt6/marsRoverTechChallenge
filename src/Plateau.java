public class Plateau {
    private int rows;
    private int cols;

    public Plateau(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public boolean isValidMove(Location location) {
        return location.getX() <= rows && location.getY() <= cols;
    }


}
