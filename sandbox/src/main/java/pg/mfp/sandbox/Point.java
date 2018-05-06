package pg.mfp.sandbox;

public class Point {
  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static String distance(Point p1, Point p2) {
    double distance = Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));
    return String.format("%.4g%n", distance);
  }
}
