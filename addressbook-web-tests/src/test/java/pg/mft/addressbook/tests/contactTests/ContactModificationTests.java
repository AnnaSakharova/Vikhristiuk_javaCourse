package pg.mft.addressbook.tests.contactTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pg.mft.addressbook.model.ContactData;
import pg.mft.addressbook.model.GroupData;
import pg.mft.addressbook.tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests  extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().goToContactCreationPage();
      app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "ivanov", "Test", "Test", "Test", "324516", "789876", "879865", "453231", "test@test.ru", "test@test.ru", "test@test.ru", "http://test.ru", "6", "7", "1972", null, "Test", "Test", "Test"), true);
      app.getNavigationHelper().goToHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContacts(before.size() - 1);
    app.getContactHelper().initContactModification(before.size()  + 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "петр", "петрович", "петров", "ivanov", "Test", "Test", "Test", "324516", "789876", "879865", "453231", "test@test.ru", "test@test.ru", "test@test.ru", "http://test.ru", "6", "7", "1972", null, "Test", "Test", "Test");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    List<ContactData> beforeList = before;
    List<ContactData> afterList = after;

    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }
}
