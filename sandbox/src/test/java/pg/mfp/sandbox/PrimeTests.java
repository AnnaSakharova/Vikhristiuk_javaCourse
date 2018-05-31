package pg.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrimes() {
    Assert.assertTrue(Primes.isPrimeForFast(Integer.MAX_VALUE));
  }

  @Test
  public void testNoPrimes() {
    Assert.assertFalse(Primes.isPrimeFor(Integer.MAX_VALUE - 2));
  }

  @Test(enabled = false)
  public void testPrimesLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimeFor(n));
  }
}
