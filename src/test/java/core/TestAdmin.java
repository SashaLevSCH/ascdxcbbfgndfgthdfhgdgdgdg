package core;


import org.testng.ITestContext;
import org.testng.annotations.Test;
import setup.BasePage;

public class TestAdmin  extends TestBase {

    @Test
    public void enrollTest(ITestContext context) {
        adminloginPage.login();
        adminDashBoardPage.clickmodule(adminDashBoardPage.care);
        adminCarePage.clickmodule(adminCarePage.addCare);
        adminCarePage.Newcareitem.click();
        BasePage.scrollToMiddle(driver,adminCarePage.Newcareitem);
        adminCarePage.enterSearchTems();
        


    }


}
