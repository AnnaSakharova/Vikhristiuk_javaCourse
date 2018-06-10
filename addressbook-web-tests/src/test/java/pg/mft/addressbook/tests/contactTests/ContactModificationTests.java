package pg.mft.addressbook.tests.contactTests;

import javafx.beans.binding.Bindings;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pg.mft.addressbook.model.ContactData;
import pg.mft.addressbook.model.Contacts;
import pg.mft.addressbook.tests.TestBase;

import java.util.*;

public class ContactModificationTests  extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().contactCreationPage();
      app.contact().create(new ContactData().withFirstName("Иван").withLastName("Иванов"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("петр").withLastName("петров");
    app.contact().modify(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
  }
}
