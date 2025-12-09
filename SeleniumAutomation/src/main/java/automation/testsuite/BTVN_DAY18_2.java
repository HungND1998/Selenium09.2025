package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BTVN_DAY18_2 extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openWebPage(@Optional("firefox") String openWebDriver) {
        setupDriver(openWebDriver);
        driver.get(CT_PageURL.BEP_AN_TOAN_URL);
    }

    @Test
    public void verifyZaloChatNavigate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String firstWindow = driver.getWindowHandle();
        click(By.xpath("(//span[text()='Chat với chúng tôi'])[2]"));
        Set<String> windows = driver.getWindowHandles();
        for (String childWindow:windows) {
            if (!childWindow.equals(firstWindow)) {
                driver.switchTo().window(childWindow);
                String actualUrl = driver.getCurrentUrl();
                System.out.println("trang url: " + actualUrl);
                Assert.assertEquals(actualUrl, "https://id.zalo.me/account/login?continue=http%3A%2F%2Fzalo.me%2F0912331335");
                driver.close();
            }
        }
        driver.switchTo().window(firstWindow);
    }
}
