package pg.mft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{
  private FirefoxDriver wd;

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String userName, String password) {
    fieldFilling("user", userName);
    fieldFilling("pass", password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
