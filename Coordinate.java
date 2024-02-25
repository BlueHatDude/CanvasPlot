public class Coordinate {

    public int x;
    public int y;
    
    private int horizontalMax;
    private int horizontalMin;
    private int verticalMax;
    private int verticalMin;
    
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    final public void setConstraints(int hmin, int hmax, int vmin, int vmax) {
        this.horizontalMin = hmin;
        this.horizontalMax = hmax;
        this.verticalMin = vmin;
        this.verticalMax = vmax;
    }
     
    final public void goUp(int amount) {
        this.y = Math.max(this.y - amount, verticalMin);
    }

    final public void goDown(int amount) {
        this.y = Math.min(this.y + amount, verticalMax);
    }
    
    final public void goLeft(int amount) {
        this.x = Math.max(this.x - amount, horizontalMin);
    }
    
    final public void goRight(int amount) {
        this.x = Math.min(this.x + amount, horizontalMax);
    }

}
