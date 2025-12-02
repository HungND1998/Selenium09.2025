package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BTVN_DAY16_2 extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.PRAC_URL);
    }

    @Test
    public void tryItAlert() {
        click(By.xpath("//button[text()='Try it']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualMessage, "Welcome to Selenium WebDriver Tutorials");
        driver.switchTo().alert().accept();
    }
}
