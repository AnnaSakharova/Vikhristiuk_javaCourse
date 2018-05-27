package pg.mft.addressbook.tests.groupTests;

import org.testng.annotations.Test;
import pg.mft.addressbook.model.GroupData;
import pg.mft.addressbook.tests.TestBase;

public class GroupDelitionTests extends TestBase {


    @Test
    public void testGroupDelition() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }


}
