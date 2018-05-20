package pg.mft.addressbook.tests;

import org.testng.annotations.Test;


public class ContactDeletionTests extends TestBase{


    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContacts();
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().goToHomePage();
    }

}
