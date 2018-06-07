package pg.mft.addressbook.tests.contactTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pg.mft.addressbook.model.ContactData;
import pg.mft.addressbook.tests.TestBase;

import java.util.*;

public class ContactModificationTests  extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().contactCreationPage();
      app.contact().create(new ContactData("Иван", "Иванович", "Иванов", "ivanov", "Test1", "Test2", "Test3", "324516", "789876", "879865", "453231", "test@test.ru", "test@test.ru", "test@test.ru", "http://test.ru", "6", "7", "1972", null, "Test4", "Test5", "Test6"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    app.contact().select(before.size() - 1);
    app.contact().initModification(before.size()  + 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "петр", "петрович", "петров", "ivanov", "Test", "Test", null, null, null, null, null, null, null, null, "http://test.ru", "6", "7", "1972", null, "Test", "Test", "Test");
    app.contact().fill(contact, false);
    app.contact().submitModification();
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
