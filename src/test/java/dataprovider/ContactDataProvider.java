package dataprovider;

import org.testng.annotations.DataProvider;
import utils.ExcelUtil;

public class ContactDataProvider {

    @DataProvider(name = "ContactData")
    public Object[][] getContactData() {

        String path = System.getProperty("user.dir")
                + "/testdata/ContactData.xlsx";

        return ExcelUtil.getTestData(path, "ContactData");
    }
}