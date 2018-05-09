package pg.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


  @Test
  public void testDistance1() {
    Point p1 = new Point(2, 2);
    Point p2 = new Point (4, 4);
    Assert.assertEquals(p1.distance(p2), "2,83");
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(-2, -2);
    Point p2 = new Point (-4, -4);
    Assert.assertEquals(p1.distance(p2), "2,83");
  }

  @Test
  public void testDistance3() {
    Point p1 = new Point(-2, 2);
    Point p2 = new Point (4, 4);
    Assert.assertEquals(p1.distance(p2), "6,32");
  }

  @Test
  public void testDistance4() {
    Point p1 = new Point(2, -2);
    Point p2 = new Point (4, 4);
    Assert.assertEquals(p1.distance(p2), "6,32");
  }

  @Test
  public void testDistance5() {
    Point p1 = new Point(2, 2);
    Point p2 = new Point (-4, 4);
    Assert.assertEquals(p1.distance(p2), "6,32");
  }

  @Test
  public void testDistance6() {
    Point p1 = new Point(2, 2);
    Point p2 = new Point (4, -4);
    Assert.assertEquals(p1.distance(p2), "6,32");
  }

  @Test
  public void testDistance7() {
    Point p1 = new Point(-2, -2);
    Point p2 = new Point (4, 4);
    Assert.assertEquals(p1.distance(p2), "8,49");
  }

  @Test
  public void testDistance8() {
    Point p1 = new Point(2, 2);
    Point p2 = new Point (-4, -4);
    Assert.assertEquals(p1.distance(p2), "8,49");
  }

  @Test
  public void testDistance9() {
    Point p1 = new Point(-2, 2);
    Point p2 = new Point (4, -4);
    Assert.assertEquals(p1.distance(p2), "8,49");
  }

  @Test
  public void testDistance10() {
    Point p1 = new Point(2, -2);
    Point p2 = new Point (-4, 4);
    Assert.assertEquals(p1.distance(p2), "8,49");
  }

  @Test
  public void testDistance11() {
    Point p1 = new Point(-999999999, -999999999);
    Point p2 = new Point (999999999, 999999999);
    Assert.assertEquals(p1.distance(p2), "2828427121,92");
  }

  @Test
  public void testDistance12() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point (200, 200);
    Assert.assertEquals(p1.distance(p2), "282,84");
  }

  @Test
  public void testDistance13() {
    Point p1 = new Point(200, 200);
    Point p2 = new Point (0, 0);
    Assert.assertEquals(p1.distance(p2), "282,84");
  }

  @Test
  public void testDistance14() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point (0, 0);
    Assert.assertEquals(p1.distance(p2), "0,00");
  }

  @Test
  public void testDistance15() {
    Point p1 = new Point(0.123, 0.456);
    Point p2 = new Point (0.678, 0.89);
    Assert.assertEquals(p1.distance(p2), "0,70");
  }

  @Test
  public void testDistance16() {
    Point p1 = new Point(123.123, 456.456);
    Point p2 = new Point (678.678, 890.89);
    Assert.assertEquals(p1.distance(p2), "705,25");
  }

  @Test
  public void testDistance17() {
    Point p1 = new Point(150, 1);
    Point p2 = new Point (150, -1);
    Assert.assertEquals(p1.distance(p2), "2,00");
  }

  @Test
  public void testDistance18() {
    Point p1 = new Point(-150, 1);
    Point p2 = new Point (150, 1);
    Assert.assertEquals(p1.distance(p2), "300,00");
  }

  @Test
  public void testDistance19() {
    Point p1 = new Point(-150, 1);
    Point p2 = new Point (-150, -1);
    Assert.assertEquals(p1.distance(p2), "2,00");
  }

  @Test
  public void testDistance20() {
    Point p1 = new Point(-150, -1);
    Point p2 = new Point (150, -1);
    Assert.assertEquals(p1.distance(p2), "300,00");
  }
}
