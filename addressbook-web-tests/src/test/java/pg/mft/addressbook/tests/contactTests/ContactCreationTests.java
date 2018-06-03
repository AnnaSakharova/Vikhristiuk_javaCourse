package pg.mft.addressbook.tests.contactTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pg.mft.addressbook.model.ContactData;
import pg.mft.addressbook.model.GroupData;
import pg.mft.addressbook.tests.TestBase;

import java.util.List;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToContactCreationPage();
        app.getContactHelper().createContact(new ContactData("Иван", "Иванович", "Иванов", "ivanov", "Test", "Test", "Test", "324516", "789876", "879865", "453231", "test@test.ru", "test@test.ru", "test@test.ru", "http://test.ru", "6", "7", "1972", "test1", "Test", "Test", "Test"), true);
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
