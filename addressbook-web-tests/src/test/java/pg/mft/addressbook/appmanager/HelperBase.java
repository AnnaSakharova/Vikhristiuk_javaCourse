package pg.mft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void fieldFilling(String locator, String text) {
    click(By.name(locator));
    if (text != null) {
      String existingText =  wd.findElement(By.name(locator)).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(By.name(locator)).clear();
        wd.findElement(By.name(locator)).sendKeys(text);
      }
    }
  }

  protected void valueSelection(String locator, String text) {
    String existingText =  wd.findElement(By.name(locator)).getText();
    if (text != null) {
      if (!text.equals(existingText)) {
        new Select(wd.findElement(By.name(locator))).selectByVisibleText(text);
      }
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert().accept();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch(NoSuchElementException ex) {
      return false;
    }
  }
}
