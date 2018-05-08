package pg.mfp.sandbox;

public class Point {
  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public String distance(Point p2) {
    double distance = Math.sqrt(Math.pow((p2.x-this.x),2) + Math.pow((p2.y-this.y),2));
    return String.format("%(.2f", distance);
  }
}
