package pg.mft.addressbook.tests;

import org.testng.annotations.Test;
import pg.mft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{


    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToContactCreationPage();
        app.getContactHelper().fillContactForm(new ContactData("Иван", "Иванович", "Иванов", "ivanov", "Test", "Test", "Test", "324516", "789876", "879865", "453231", "test@test.ru", "test@test.ru", "test@test.ru", "http://test.ru", "6", "7", "1972", "Test", "Test", "Test"));
        app.getContactHelper().submitContactForm();
        app.getNavigationHelper().goToHomePage();
    }

}
