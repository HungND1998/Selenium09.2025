package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Set;

public class BTVN_DAY18_1 extends CommonBase {
    @BeforeMethod
    @Parameters("browser") //browser là name của parameter trong testNG
    public void openWebPage(@Optional("firefox") String browserSetup) {
        setupDriver(browserSetup);
        driver.get(CT_PageURL.DIEN_MAY_URL);
    }

    @Test
    public void verifyZaloNavigation() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String firstWindow = driver.getWindowHandle();
        clickByJS(By.xpath("//img[@alt='Zalo']/parent::a"));
        Set<String> windows = driver.getWindowHandles();
        for (String childWindow:windows) {
            if (!childWindow.equals(firstWindow)) {
                driver.switchTo().window(childWindow);
                String actualUrl = driver.getCurrentUrl();
                System.out.println("trang url: " + actualUrl);
                Assert.assertEquals(actualUrl, "https://id.zalo.me/account/login?continue=http%3A%2F%2Fzalo.me%2F0965880198");
                driver.close();
            }
        }
        driver.switchTo().window(firstWindow);
    }

}
