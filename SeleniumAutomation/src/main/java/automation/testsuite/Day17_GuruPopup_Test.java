package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.Day17_GuruPopup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class Day17_GuruPopup_Test extends CommonBase {

    @BeforeMethod
    public void openGuruPage() {
        driver = initFirefoxDriver(CT_PageURL.GURU_POPUP_URL);
    }

    @Test
    public void getDetailAccess_Successfully() {
        //1. tìm window đầu tiên (main, first)
        String firstWindow = driver.getWindowHandle();
        // click button để mở ra các window con
        click(By.xpath("//a[text()='Click Here']"));
        // Lấy các windows con rồi xử lý trên trang cần test
        Set<String> windows = driver.getWindowHandles();
        for (String childWindow:windows) {
            if (!childWindow.equals(firstWindow)) {
                driver.switchTo().window(childWindow);
                Day17_GuruPopup guruPage = new Day17_GuruPopup(driver);
                guruPage.getAccessDetail();
               assertTrue(isDisplay_fluent(By.xpath("//h2[text()='Access details to demo site.']")));
               driver.close();
            }
        }
        // Trở về window đầu tiên
        driver.switchTo().window(firstWindow);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://demo.guru99.com/popup.php");
    }
}
