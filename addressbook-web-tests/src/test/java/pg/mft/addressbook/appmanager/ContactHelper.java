package pg.mft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pg.mft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    fieldFilling("firstname", contactData.getFirstName());
    fieldFilling("middlename", contactData.getMiddleName());
    fieldFilling("lastname", contactData.getLastName());
    fieldFilling("nickname", contactData.getNickName());
    fieldFilling("title", contactData.getTitle());
    fieldFilling("company", contactData.getCompany());
    fieldFilling("address", contactData.getAddress());
    fieldFilling("home", contactData.getHomePhone());
    fieldFilling("mobile", contactData.getMobilePhone());
    fieldFilling("work", contactData.getWorkPhone());
    fieldFilling("fax", contactData.getFaxPhone());
    fieldFilling("email", contactData.getEmail1());
    fieldFilling("email2", contactData.getEmail2());
    fieldFilling("email3", contactData.getEmail3());
    fieldFilling("homepage", contactData.getHomePage());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + contactData.getBirthDay() + "]")).isSelected()) {
       click(By.xpath("//div[@id='content']/form/select[1]//option[" + contactData.getBirthDay() + "]"));
      }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[" + contactData.getBirthMonth() + "]")).isSelected()) {
       click(By.xpath("//div[@id='content']/form/select[2]//option[" + contactData.getBirthMonth() + "]"));
      }
    fieldFilling("byear", contactData.getBirthYear());
    fieldFilling("address2", contactData.getAddress2());
    fieldFilling("phone2", contactData.getPhone2());
    fieldFilling("notes", contactData.getNotes());
  }

  public void deleteSelectedContacts() {
      click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
      isAlertPresent();
  }

  public void selectContacts() {
    click(By.name("selected[]"));
  }
}
