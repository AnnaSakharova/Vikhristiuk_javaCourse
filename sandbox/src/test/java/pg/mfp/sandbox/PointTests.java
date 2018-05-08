package pg.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


  public void distanceCalculation(double x1, double y1, double x2, double y2, String result) {
    Point p1 = new Point(x1, y1);
    Point p2 = new Point (x2, y2);
    Assert.assertEquals(p1.distance(p2), result);
  }

  @Test
  public void testDistance1() {
    distanceCalculation(2, 2, 4, 4, "2,83");
  }

  @Test
  public void testDistance2() {
    distanceCalculation(-2, -2, -4, -4, "2,83");
  }

  @Test
  public void testDistance3() {
    distanceCalculation(-2, 2, 4, 4, "6,32");
  }

  @Test
  public void testDistance4() {
    distanceCalculation(2, -2, 4, 4, "6,32");
  }

  @Test
  public void testDistance5() {
    distanceCalculation(2, 2, -4, 4, "6,32");
  }

  @Test
  public void testDistance6() {
    distanceCalculation(2, 2, 4, -4, "6,32");
  }

  @Test
  public void testDistance7() {
    distanceCalculation(-2, -2, 4, 4, "8,49");
  }

  @Test
  public void testDistance8() {
    distanceCalculation(2, 2, -4, -4, "8,49");
  }

  @Test
  public void testDistance9() {
    distanceCalculation(-2, 2, 4, -4, "8,49");
  }

  @Test
  public void testDistance10() {
    distanceCalculation(2, -2, -4, 4, "8,49");
  }

  @Test
  public void testDistance11() {
    distanceCalculation(-999999999, -999999999, 999999999, 999999999, "2828427121,92");
  }

  @Test
  public void testDistance12() {
    distanceCalculation(0, 0, 200, 200, "282,84");
  }

  @Test
  public void testDistance13() {
    distanceCalculation(200, 200, 0, 0, "282,84");
  }

  @Test
  public void testDistance14() {
    distanceCalculation(0, 0, 0, 0, "0,00");
  }

  @Test
  public void testDistance15() {
    distanceCalculation(0.123, 0.456, 0.678, 0.89, "0,70");
  }

  @Test
  public void testDistance16() {
    distanceCalculation(123.123, 456.456, 678.678, 890.89, "705,25");
  }

  @Test
  public void testDistance17() {
    distanceCalculation(150, 1, 150, -1, "2,00");
  }

  @Test
  public void testDistance18() {
    distanceCalculation(-150, 1, 150, 1, "300,00");
  }

  @Test
  public void testDistance19() {
    distanceCalculation(-150, 1, -150, -1, "2,00");
  }

  @Test
  public void testDistance20() {
    distanceCalculation(-150, -1, 150, -1, "300,00");
  }
}
