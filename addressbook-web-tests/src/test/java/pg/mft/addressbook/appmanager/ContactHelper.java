package pg.mft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pg.mft.addressbook.model.ContactData;
import pg.mft.addressbook.model.Contacts;

import java.util.List;

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
    contactCache = null;
  }

  public void modify(ContactData contact) {
    initModificationById(contact.getId());
    fill(contact, false);
    submitModification();
    contactCache = null;
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
    contactCache = null;
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> entries = wd.findElements(By.name("entry"));
    List<WebElement> strings;
    for (WebElement entry : entries) {
      strings = entry.findElements(By.tagName("td"));
      int id = Integer.parseInt(entry.findElement(By.name("selected[]")).getAttribute("value"));
      String lastName = strings.get(1).getText();
      String firstName = strings.get(2).getText();
      String address = strings.get(3).getText();
      //String[] phones = strings.get(5).getText().split("\n");
      String allPhones = strings.get(5).getText();
      //String[] emails = strings.get(4).getText().split("\n");
      String allEmails = strings.get(4).getText();
      /*contactCache.add(new ContactData()
              .withId(id).withFirstName(firstName)
              .withLastName(lastName)
              .withHomePhone(phones[0]).withMobilePhone(phones[1])
              .withWorkPhone(phones[2]).withFaxPhone(phones[3])
              .withEmail1(emails[0]).withEmail2(emails[1]).withEmail3(emails[2]));*/
      contactCache.add(new ContactData()
              .withId(id).withFirstName(firstName).withLastName(lastName)
              .withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
      strings.clear();
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditPage(ContactData contact) {
    initModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId()).withFirstName(firstName)
            .withLastName(lastName).withAddress(address)
            .withHomePhone(home).withMobilePhone(mobile)
            .withWorkPhone(work).withFaxPhone(fax)
            .withEmail1(email1).withEmail2(email2).withEmail3(email3);
  }


}
