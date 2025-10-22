public class ColorPoint2 extends Point {
    private String color;

    public ColorPoint2(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public ColorPoint2(int x, int y) {
        super(x, y);
        this.color = "BLACK";
    }

    public ColorPoint2() {
        this(0, 0, "WHITE");
    }

    public void set(String color) {
        this.color = color;
    }

    public void set(int x, int y) {
        move(x, y);
    }

    double getDistance(Point p) {
        double xDistance = getX() - p.getX();
        double yDistance = getY() - p.getY();
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    @Override
    public String toString() {
        return color + "색의 " + "(" + getX() + "," + getY() + ")의 점";
    }
}
