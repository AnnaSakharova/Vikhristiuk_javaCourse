package pg.mft.addressbook.tests.groupTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pg.mft.addressbook.model.GroupData;
import pg.mft.addressbook.tests.TestBase;

import java.util.List;

public class GroupDelitionTests extends TestBase {


    @Test
    public void testGroupDelition() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }


}
