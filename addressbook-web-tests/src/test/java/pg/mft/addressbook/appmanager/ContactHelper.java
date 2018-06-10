package pg.mft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pg.mft.addressbook.model.ContactData;
import pg.mft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fill(ContactData contactData, boolean creation) {
    fieldFilling("firstname", contactData.getFirstName());
   // fieldFilling("middlename", contactData.getMiddleName());
    fieldFilling("lastname", contactData.getLastName());
    /*fieldFilling("nickname", contactData.getNickName());
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

    if(creation) {
      valueSelection("new_group", contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    fieldFilling("address2", contactData.getAddress2());
    fieldFilling("phone2", contactData.getPhone2());
    fieldFilling("notes", contactData.getNotes());*/
  }


  public void delete(ContactData contact) {
    selectById(String.valueOf(contact.getId()));
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    isAlertPresent();
  }

  public void modify(ContactData contact) {
    initModificationById(contact.getId());
    fill(contact, false);
    submitModification();
  }

  private void selectById(String id) {
    wd.findElement(By.id(id)).click();
  }

  public void initModificationById(int id) {
    click(By.cssSelector("a[href=\"edit.php?id=" + id + "\"]"));
  }


  public void submitModification() {
    click(By.name("update"));
  }

  public void create(ContactData contactData, boolean creation) {
    fill(contactData, creation);
    submitContactForm();

  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> entries = wd.findElements(By.name("entry"));
    List<WebElement> strings;
    for (WebElement entry : entries) {
      strings = entry.findElements(By.tagName("td"));
      int id = Integer.parseInt(entry.findElement(By.name("selected[]")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(strings.get(2).getText()).withLastName(strings.get(1).getText()));
      strings.clear();
    }
    return contacts;
  }


}
