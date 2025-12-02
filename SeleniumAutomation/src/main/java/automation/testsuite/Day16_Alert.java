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

public class Day16_Alert extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.GURU_TEST_URL);
    }

    @Test
    public void deleteCustSuccessfully() {
        type(By.name("cusid"), "13244");
        click(By.name("submit"));
        driver.switchTo().alert().accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualMessage, "Customer Successfully Delete!");
        driver.switchTo().alert().accept();
    }
}
