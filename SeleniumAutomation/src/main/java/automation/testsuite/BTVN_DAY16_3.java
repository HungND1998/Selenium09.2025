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

public class BTVN_DAY16_3 extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.ALERT_URL);
    }

    @Test
    public void alertWithOk() {
        click(By.xpath("//button[normalize-space()='click the button to display an alert box:']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualMessage, "I am an alert box!");
        driver.switchTo().alert().accept();
    }

    @Test
    public void alertWithOkCancel() {
        click(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
        click(By.xpath("//button[normalize-space()='click the button to display a confirm box']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualMessage, "Press a Button !");
        driver.switchTo().alert().accept();
    }

    @Test
    public void alertWithTextBox() {
        click(By.xpath("//a[normalize-space()='Alert with Textbox']"));
        click(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("Hello selenium");
        driver.switchTo().alert().accept();

    }
}
