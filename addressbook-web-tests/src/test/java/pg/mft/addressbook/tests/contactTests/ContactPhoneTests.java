package pg.mft.addressbook.tests.contactTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pg.mft.addressbook.model.ContactData;
import pg.mft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

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
  public void testPhones() {
    ensurePreconditions();
    ContactData contact = app.contact().all().iterator().next();
    ContactData infoFromEditPage = app.contact().infoFromEditPage(contact);
      assertThat(contact.getAllPhones(), equalTo(mergedPhones(infoFromEditPage)));
  }

  @Test
  public void testEmails() {
    ensurePreconditions();
    ContactData contact = app.contact().all().iterator().next();
    ContactData infoFromEditPage = app.contact().infoFromEditPage(contact);
    assertThat(contact.getAllEmails(), equalTo(mergedEmails(infoFromEditPage)));
  }

  @Test
  public void testAddress() {
    ensurePreconditions();
    ContactData contact = app.contact().all().iterator().next();
    ContactData infoFromEditPage = app.contact().infoFromEditPage(contact);
    assertThat(contact.getAddress(), equalTo(infoFromEditPage.getAddress()));
  }


  private String mergedPhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getFaxPhone())
    .stream().filter((s) -> !s.equals(""))
    .map(ContactPhoneTests::cleaned)
    .collect(Collectors.joining("\n"));
  }

  private String mergedEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("-()", "");
  }
}
