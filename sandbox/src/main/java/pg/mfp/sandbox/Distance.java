package pg.mfp.sandbox;

public class Distance {

  Point p1;
  Point p2;

  public Distance(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public String distance() {
    double distance = Math.sqrt(Math.pow((this.p2.x-this.p1.x),2) + Math.pow((this.p2.y-this.p1.y),2));
    return String.format("%.4g%n", distance);
  }
}
