package pg.mft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String userName, String password) {
    fieldFilling("user", userName);
    fieldFilling("pass", password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
