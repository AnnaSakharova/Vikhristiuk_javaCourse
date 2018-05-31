package pg.mft.addressbook.tests.groupTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pg.mft.addressbook.model.GroupData;
import pg.mft.addressbook.tests.TestBase;

import java.util.List;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }


}
