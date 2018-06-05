package pg.mft.addressbook.tests.contactTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pg.mft.addressbook.model.ContactData;
import pg.mft.addressbook.tests.TestBase;

import java.util.List;


public class ContactDeletionTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (! app.contact().isThereAContact()) {
            app.goTo().contactCreationPage();
            app.contact().create(new ContactData("Иван", "Иванович", "Иванов", "ivanov", "Test1", "Test2", "Test3", "324516", "789876", "879865", "453231", "test@test.ru", "test@test.ru", "test@test.ru", "http://test.ru", "6", "7", "1972", null, "Test4", "Test5", "Test6"), true);
            app.goTo().homePage();
        }
    }


    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        app.contact().select(before.size() - 1);
        app.contact().deleteSelectedContacts();
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}
